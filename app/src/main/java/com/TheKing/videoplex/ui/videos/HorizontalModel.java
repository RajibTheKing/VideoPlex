package com.TheKing.videoplex.ui.videos;

public class HorizontalModel {
    public String name;
    public String videoID;



    public HorizontalModel(String name, String videoID) {
        this.name = name;
        this.videoID = videoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }
}
