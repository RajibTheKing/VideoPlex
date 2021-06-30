package com.TheKing.videoplex.ui.gridView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;

import com.TheKing.videoplex.ui.home.PlayVideo;
import com.TheKing.videoplex.ui.model.Video;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class GridViewRecyclerViewAdapter extends RecyclerView.Adapter implements Filterable {
    Context context;
    ArrayList<Video_Data> arrayList;
    ArrayList<Video_Data> arrayListFull;

    public GridViewRecyclerViewAdapter(Context context, ArrayList<Video_Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        arrayListFull = new ArrayList<>(arrayList);
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        GridViewHolderClass gridViewHolderClass = new GridViewHolderClass(view);
        return gridViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        GridViewHolderClass viewHolderClass = (GridViewHolderClass)holder;
        Video_Data singleVideoModel = arrayList.get(position);
        viewHolderClass.textView.setText(singleVideoModel.getTitle());


        YoYo.with(Techniques.Tada)
                .duration(2000)
                .playOn(viewHolderClass.imageView);


        String imageURL = "";
        if(singleVideoModel.getPoster().length() > 0){
            imageURL = singleVideoModel.getPoster();
        }else{
            imageURL = singleVideoModel.getThumbnail_URL();
        }

        new DownloadImageTask(viewHolderClass.imageView).execute(imageURL);

        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, horizontalModel.getName() + " --> Selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, PlayVideo.class);
                intent.putExtra("VIDEO_URL", singleVideoModel.getID());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class GridViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public GridViewHolderClass(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    @Override
    public Filter getFilter() {
        return OurSearchFilter;
    }

    private Filter OurSearchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Video_Data> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(arrayListFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Video_Data item : arrayListFull){
                    if (item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList.clear();
            arrayList.addAll((ArrayList<Video_Data>) results.values);
            notifyDataSetChanged();
        }
    };
}
