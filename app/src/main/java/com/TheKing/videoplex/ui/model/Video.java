package com.TheKing.videoplex.ui.model;


import java.util.ArrayList;
import java.util.Date;

public class Video {
    ArrayList<Video_Data> VideoData;

    public ArrayList<Video_Data> getVideoData() {
        return VideoData;
    }

    public void setVideoData(ArrayList<Video_Data> videoData) {
        VideoData = videoData;
    }

    public String toString() {

        String result = "";
        for(int i = 0; i<VideoData.size(); i++){
            com.TheKing.videoplex.ui.model.Video_Data data = VideoData.get(i);
            String curr = String.format("{ID:%s,Category:%s,Title:%s,URL:%s}",
                    data.ID, data.Category, data.Title, data.URL);
            result = result + curr + "\n";


        }
        return result;
    }
}


