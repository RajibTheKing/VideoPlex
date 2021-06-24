package com.TheKing.videoplex.ui.videos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;


import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;

import com.TheKing.videoplex.ui.videos.PlayVideo;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);
        HorizontalViewHolderClass horizontalViewHolderClass = new HorizontalViewHolderClass(view);
        return horizontalViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        HorizontalViewHolderClass viewHolderClass = (HorizontalViewHolderClass)holder;
        HorizontalModel horizontalModel = arrayList.get(position);
        viewHolderClass.textView.setText(horizontalModel.getVideoModel().Title);
        String imageURL = horizontalModel.getVideoModel().Thumbnail_URL;
        new DownloadImageTask(viewHolderClass.imageView).execute(imageURL);

        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, horizontalModel.getName() + " --> Selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, PlayVideo.class);
                intent.putExtra("VIDEO_URL",horizontalModel.getVideoModel().ID);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public HorizontalViewHolderClass(@NonNull @NotNull View itemView) {
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
}
