package com.TheKing.videoplex.ui.videos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    RecyclerView verticalRecyclerView;
    ArrayList<VerticalModel> arrayList;
    //https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        verticalRecyclerView = view.findViewById(R.id.verticalRecyclerView);
        // Inflate the layout for this fragment
        new JsonData(this).execute("https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json");


        //return startRecyclerView(view);
        return view;
    }

    public void setDataInRecyclerView(Artist artist){

        VerticalRecyclerViewAdapter verticalRecyclerViewAdapter = new VerticalRecyclerViewAdapter(getContext(), getData());
        LinearLayoutManager vertical_linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        verticalRecyclerView.setLayoutManager(vertical_linearLayoutManager);
        verticalRecyclerView.setAdapter(verticalRecyclerViewAdapter);

    }

    public ArrayList<VerticalModel> getData(){
        int row = 20;
        int col = 10;
        ArrayList<VerticalModel> ret = new ArrayList<VerticalModel>();
        for(int i= 0; i<row; i++){
            ArrayList<HorizontalModel> cur = new ArrayList<HorizontalModel>();
            for(int j = 0; j<col; j++){
                HorizontalModel horizontalItem = new HorizontalModel("Name: " + j, "https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/images/artist/Tanjin_Tisha_Thumbnail_1366x768.jpg");
                cur.add(horizontalItem);
            }
            VerticalModel verticalModel = new VerticalModel("Title: "+i, cur);
            ret.add(verticalModel);
        }

        return ret;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}