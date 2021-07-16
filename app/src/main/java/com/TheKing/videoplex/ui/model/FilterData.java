package com.TheKing.videoplex.ui.model;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterData {
    String searchQuery;
    HashMap<String, ArrayList<String>> extendedData;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public HashMap<String, ArrayList<String>> getExtendedData() {
        return extendedData;
    }

    public void setExtendedData(HashMap<String, ArrayList<String>> extendedData) {
        this.extendedData = extendedData;
    }
}
