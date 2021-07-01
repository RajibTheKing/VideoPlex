package com.TheKing.videoplex.ui.home;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;

import com.TheKing.videoplex.ui.Preview.PreviewActivity;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<Video_Data> arrayList;
    Gson gson;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<Video_Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        HorizontalViewHolderClass horizontalViewHolderClass = new HorizontalViewHolderClass(view);
        return horizontalViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        HorizontalViewHolderClass viewHolderClass = (HorizontalViewHolderClass)holder;
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

        Glide.with(this.context).load(imageURL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolderClass.imageView);

        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, horizontalModel.getName() + " --> Selected", Toast.LENGTH_LONG).show();

                if (singleVideoModel.getCategory().compareTo("Movie") == 0){

                    Intent intent = new Intent(context, PreviewActivity.class);
                    String singleVideoInJson = gson.toJson(singleVideoModel);
                    intent.putExtra("singleVideoJson", singleVideoInJson);
                    context.startActivity(intent);

                }else{
                    Intent intent = new Intent(context, PlayVideo.class);
                    intent.putExtra("VIDEO_URL", singleVideoModel.getID());
                    context.startActivity(intent);
                }




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
}
