package com.TheKing.videoplex.ui.home;
import com.TheKing.videoplex.ui.model.Video_Data;

import java.util.ArrayList;

public class VerticalModel {
    public String title;
    ArrayList<Video_Data> arrayList;

    public VerticalModel(String title, ArrayList<Video_Data> arrayList) {
        this.title = title;
        this.arrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Video_Data> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Video_Data> arrayList) {
        this.arrayList = arrayList;
    }
}
