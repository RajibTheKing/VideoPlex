package com.TheKing.videoplex.ui.videos;

public class HorizontalModel {
    public String name;
    public String image_url;

    public String getName() {
        return name;
    }

    public HorizontalModel(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
