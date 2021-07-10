package com.TheKing.videoplex.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.model.Video;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.TheKing.videoplex.utility.SharedPreferenceUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;



public class VideoFragment extends Fragment {

    SharedPreferenceUtility sharedPreferenceUtility;
    RecyclerView verticalRecyclerView;
    ArrayList<VerticalModel> arrayList;
    //https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        verticalRecyclerView = view.findViewById(R.id.verticalRecyclerView);
        sharedPreferenceUtility = new SharedPreferenceUtility();

        // Inflate the layout for this fragment
        new JsonData(this).execute("https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Video.json");

        //return startRecyclerView(view);
        return view;
    }


    public void setDataInRecyclerView(String data){
        // Now do the magic.
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        Video video = gson.fromJson(data, Video.class);

        if(video == null){
            Toast.makeText(this.getContext(), "FAILED: Fetching Data. Please Check your Network Connection", Toast.LENGTH_SHORT).show();
            return;
        }

        sharedPreferenceUtility.StoreData(this.getContext(), video);

        //Log.d("TheKing--> video Dta = ", "> " + video);

        HashMap<String, ArrayList<Video_Data>> categoryMap = new HashMap<String, ArrayList<Video_Data>>();

        for(int i=0; i<video.getVideoData().size(); i++){
            Video_Data singleVideoModel = video.getVideoData().get(i);

            if(categoryMap.get(video.getVideoData().get(i).getCategory()) == null ){
                ArrayList<Video_Data> list = new ArrayList<Video_Data>();
                list.add(singleVideoModel);
                categoryMap.put(video.getVideoData().get(i).getCategory(), list);
            }else{
                ArrayList<Video_Data> list = categoryMap.get(video.getVideoData().get(i).getCategory());
                list.add(singleVideoModel);
                categoryMap.put(video.getVideoData().get(i).getCategory(), list);
            }
        }

        Set<String> categories = categoryMap.keySet();

        ArrayList<VerticalModel> parsedData = new ArrayList<VerticalModel>();
        for (String category : categories) {
            ArrayList<Video_Data> cur = categoryMap.get(category);
            VerticalModel verticalModel = new VerticalModel(category, cur);
            parsedData.add(verticalModel);

        }

        VerticalRecyclerViewAdapter verticalRecyclerViewAdapter = new VerticalRecyclerViewAdapter(getContext(), parsedData);
        LinearLayoutManager vertical_linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        verticalRecyclerView.setLayoutManager(vertical_linearLayoutManager);
        verticalRecyclerView.setAdapter(verticalRecyclerViewAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}