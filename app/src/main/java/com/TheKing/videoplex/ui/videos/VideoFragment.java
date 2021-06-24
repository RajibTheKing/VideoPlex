package com.TheKing.videoplex.ui.videos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class VideoFragment extends Fragment {

    RecyclerView verticalRecyclerView;
    ArrayList<VerticalModel> arrayList;
    //https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        verticalRecyclerView = view.findViewById(R.id.verticalRecyclerView);
        // Inflate the layout for this fragment
        new JsonData(this).execute("https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Video.json");

        //return startRecyclerView(view);
        return view;
    }


    public void setDataInRecyclerView(String data){
        // Now do the magic.
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        Video video = gson.fromJson(data, Video.class);

        Log.d("TheKing--> video Dta = ", "> " + video);

        HashMap<String, ArrayList<HorizontalModel>> categoryMap = new HashMap<String, ArrayList<HorizontalModel>>();

        for(int i=0; i<video.VideoData.size(); i++){
            HorizontalModel horizontalModel = new HorizontalModel(video.VideoData.get(i));

            if(categoryMap.get(video.VideoData.get(i).getCategory()) == null ){
                ArrayList<HorizontalModel> list = new ArrayList<HorizontalModel>();
                list.add(horizontalModel);
                categoryMap.put(video.VideoData.get(i).getCategory(), list);
            }else{
                ArrayList<HorizontalModel> list = categoryMap.get(video.VideoData.get(i).getCategory());
                list.add(horizontalModel);
                categoryMap.put(video.VideoData.get(i).getCategory(), list);
            }
        }

        Set<String> categories = categoryMap.keySet();

        ArrayList<VerticalModel> parsedData = new ArrayList<VerticalModel>();
        for (String category : categories) {
            ArrayList<HorizontalModel> cur = categoryMap.get(category);
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