package com.TheKing.videoplex.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.model.Video;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class SharedPreferenceUtility
{
    Gson gson;
    final String favorite_list_tag = "FAVORITE_LIST_TAG";
    final String video_data_tag = "VIDEO_DATA_TAG";

    public SharedPreferenceUtility(){
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    public void StoreFavoriteList(Context context, ArrayList<String> favoriteList){
        String jsonStr = gson.toJson(favoriteList).toString();
        SharedPreferences sharedPref = context.getSharedPreferences(favorite_list_tag, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(favorite_list_tag, jsonStr);
        editor.apply();

    }

    public ArrayList<String> GetFavoriteList(Context context){
        ArrayList<String> favoriteList = new ArrayList<>();
        SharedPreferences sharedPref = context.getSharedPreferences(favorite_list_tag, Context.MODE_PRIVATE);
        String jsonStr = sharedPref.getString(favorite_list_tag, null);

        if(jsonStr == null)
            return favoriteList;


        favoriteList = gson.fromJson(jsonStr,favoriteList.getClass());
        return favoriteList;
    }

    public void StoreData(Context context, Video video){
        String jsonStr = gson.toJson(video).toString();
        SharedPreferences sharedPref = context.getSharedPreferences(video_data_tag, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(video_data_tag, jsonStr);
        editor.apply();

    }

    public Video GetData(Context context){
        Video video = new Video();
        SharedPreferences sharedPref = context.getSharedPreferences(video_data_tag, Context.MODE_PRIVATE);
        String jsonStr = sharedPref.getString(video_data_tag, null);

        if(jsonStr == null)
            return video;


        video = gson.fromJson(jsonStr,video.getClass());
        return video;
    }


}
