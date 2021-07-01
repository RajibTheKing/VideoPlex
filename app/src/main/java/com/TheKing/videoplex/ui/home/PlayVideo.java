package com.TheKing.videoplex.ui.home;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.TheKing.videoplex.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideo extends YouTubeBaseActivity{

    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    YoutubeConfig config;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Log.d("TheKing-->", "onCreate Called ----------->>>>>>>>>>>>>>>");

        config = new YoutubeConfig();
        setContentView(R.layout.activity_play_video);

        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.playerView);

        //Get Parameter Value:
        Bundle b = getIntent().getExtras();
        String videoID = b.getString("VIDEO_URL");



        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("TheKing-->", "Youtube Initialization is Successful");
                youTubePlayer.cueVideo(videoID);
                youTubePlayer.setFullscreen(true);
                //youTubePlayer.loadVideo(videoID);
                youTubePlayer.play();

                youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                    @Override
                    public void onPlaying() {

                        Log.d("TheKing-->", "inside onPlaying");

                    }

                    @Override
                    public void onPaused() {

                        Log.d("TheKing-->", "inside onPaused");
                    }

                    @Override
                    public void onStopped() {

                        Log.d("TheKing-->", "inside onStopped");
                    }

                    @Override
                    public void onBuffering(boolean b) {
                        Log.d("TheKing-->", "inside onBuffering");
                    }

                    @Override
                    public void onSeekTo(int i) {
                        Log.d("TheKing-->", "inside onSeekTo");
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("TheKing-->", "Youtube Initialization FAILED");

            }
        };

        mYoutubePlayerView.initialize(config.getAPI_KEY(), mOnInitializedListener);

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        Log.d("TheKing-->", "configuration changed super called");
    }
}