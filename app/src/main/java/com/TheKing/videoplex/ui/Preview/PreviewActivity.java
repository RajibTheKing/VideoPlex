package com.TheKing.videoplex.ui.Preview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.home.PlayVideo;
import com.TheKing.videoplex.ui.home.VerticalModel;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.TheKing.videoplex.utility.SharedPreferenceUtility;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {
    Gson gson;
    Video_Data singleVideo;
    Context context;
    ArrayList<String> favoriteList;
    SharedPreferenceUtility sharedPreferenceUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        sharedPreferenceUtility = new SharedPreferenceUtility();
        favoriteList = sharedPreferenceUtility.GetFavoriteList(context);

        setContentView(R.layout.activity_preview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.previewToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        //Get Parameter Value:
        Bundle b = getIntent().getExtras();
        String singleVideoInJson = b.getString("singleVideoJson");

        singleVideo = gson.fromJson(singleVideoInJson, Video_Data.class);

        ImageView previewImageView = findViewById(R.id.previewImage);
        Glide.with(this).load(singleVideo.getPoster()).into(previewImageView);


        TextView preview_Title_Text = findViewById(R.id.preview_title_text);
        preview_Title_Text.setText(singleVideo.getTitle());
        YoYo.with(Techniques.ZoomIn)
                .duration(2000)
                .playOn(preview_Title_Text);


        ImageButton preview_PlayButton = findViewById(R.id.preview_play_button);
        preview_PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideo.class);
                intent.putExtra("VIDEO_URL", singleVideo.getID());
                context.startActivity(intent);
            }
        });

        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .repeat(YoYo.INFINITE)
                .playOn(preview_PlayButton);


        TextView preview_gnre_duration_release_textview = findViewById(R.id.preview_gnre_duration_year_text);
        String strToShow = "";
        for(int i = 0; i< singleVideo.getGenre().size(); i++){
            strToShow += singleVideo.getGenre().get(i);
            if(i>=2){
                break;
            }
            if(i < (singleVideo.getGenre().size() - 1)){
                strToShow += ", ";
            }
        }
        strToShow += " | ";
        strToShow += singleVideo.getDuration();
        strToShow += " | ";
        strToShow += "Released: " + singleVideo.getReleased();
        preview_gnre_duration_release_textview.setText(strToShow);

        TextView preview_rating_text = findViewById(R.id.preview_rating_text);
        if(singleVideo.getRatings().size()>0){
            preview_rating_text.setText(singleVideo.getRatings().get(0).getValue());
        }else{
            preview_rating_text.setVisibility(View.INVISIBLE);
        }


        TextView preview_like_count = findViewById(R.id.preview_like_count_text);
        preview_like_count.setText(String.valueOf(singleVideo.getLikeCount()) + " likes");
        YoYo.with(Techniques.Swing)
                .duration(2000)
                .playOn(preview_like_count);

        TextView preview_dislike_count = findViewById(R.id.preview_dislike_count_text);
        preview_dislike_count.setText(String.valueOf(singleVideo.getDislikeCount()) + " dislikes");
        YoYo.with(Techniques.Swing)
                .duration(2000)
                .playOn(preview_dislike_count);

        TextView preview_ViewCount = findViewById(R.id.preview_viewCount_text);
        preview_ViewCount.setText(String.valueOf(singleVideo.getViewCount()) + " views");
        YoYo.with(Techniques.Swing)
                .duration(2000)
                .playOn(preview_ViewCount);

        TextView preview_Plot = findViewById(R.id.preview_plot_text);
        preview_Plot.setText(singleVideo.getPlot());





        ImageButton back_button = findViewById(R.id.preview_actionbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ImageButton favorite_button = findViewById(R.id.preview_actionbar_favorite_button);


        if(favoriteList.contains(singleVideo.getID())){
            favorite_button.setImageResource(R.drawable.ic_baseline_favorite_24_filled);
        }else{
            favorite_button.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }
        favorite_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(favoriteList.contains(singleVideo.getID())){
                    favorite_button.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    favoriteList.remove(singleVideo.getID());
                }else{
                    favorite_button.setImageResource(R.drawable.ic_baseline_favorite_24_filled);
                    favoriteList.add(singleVideo.getID());
                }

                sharedPreferenceUtility.StoreFavoriteList(context, favoriteList);
            }
        });



    }
}