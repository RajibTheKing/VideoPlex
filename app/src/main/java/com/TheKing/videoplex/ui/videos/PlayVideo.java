package com.TheKing.videoplex.ui.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.TheKing.videoplex.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideo extends YouTubeBaseActivity {

    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    YoutubeConfig config;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config = new YoutubeConfig();
        setContentView(R.layout.activity_play_video);

        btnPlay = (Button)findViewById(R.id.playBtn);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.playerView);

        //Get Parameter Value:
        Bundle b = getIntent().getExtras();
        String videoID = b.getString("VIDEO_URL");



        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("TheKing-->", "Youtube Initialization is Successful");
                youTubePlayer.loadVideo(videoID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("TheKing-->", "Youtube Initialization FAILED");

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TheKing-->", "Initializing mYoutubePlayerView");
                mYoutubePlayerView.initialize(config.getAPI_KEY(), mOnInitializedListener);
            }
        });


    }
}