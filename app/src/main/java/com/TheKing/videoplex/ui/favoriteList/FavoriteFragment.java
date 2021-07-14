package com.TheKing.videoplex.ui.favoriteList;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.gridView.GridViewRecyclerViewAdapter;
import com.TheKing.videoplex.ui.gridView.SpaceItemDecoration;
import com.TheKing.videoplex.ui.home.VerticalModel;
import com.TheKing.videoplex.ui.model.Video;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.TheKing.videoplex.utility.SharedPreferenceUtility;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


public class FavoriteFragment extends Fragment {
    SharedPreferenceUtility sharedPreferenceUtility;
    RecyclerView gridRecyclerView;
    FavoriteRecyclerViewAdapter favoriteRecyclerViewAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        sharedPreferenceUtility = new SharedPreferenceUtility();
        Video video =  sharedPreferenceUtility.GetData(this.getContext());
        ArrayList<String> favoriteList = sharedPreferenceUtility.GetFavoriteList(this.getContext());

        ArrayList<Video_Data> videoData = new ArrayList<>();

        for(int i=0; i<video.getVideoData().size(); i++){
            Video_Data cur = video.getVideoData().get(i);

            if(favoriteList.contains(cur.getID())){
                videoData.add(cur);
            }
        }

        VerticalModel verticalModel = new VerticalModel("Favorites", videoData);

        gridRecyclerView = view.findViewById(R.id.favorite_grid_view);


        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_intra_space);
        GridLayoutManager gridLayoutManager;

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            gridLayoutManager = new GridLayoutManager(this.getContext(), 3);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, 3));
        }
        else{
            gridLayoutManager = new GridLayoutManager(this.getContext(), 4);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, 4));
        }
        favoriteRecyclerViewAdapter = new FavoriteRecyclerViewAdapter(this.getContext(), verticalModel.getArrayList());
        gridRecyclerView.setAdapter(favoriteRecyclerViewAdapter);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}