package com.TheKing.videoplex.ui.videos;

import java.util.ArrayList;

public class VerticalModel {
    public String title;
    ArrayList<HorizontalModel> arrayList;

    public VerticalModel(String title, ArrayList<HorizontalModel> arrayList) {
        this.title = title;
        this.arrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<HorizontalModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalModel> arrayList) {
        this.arrayList = arrayList;
    }
}
