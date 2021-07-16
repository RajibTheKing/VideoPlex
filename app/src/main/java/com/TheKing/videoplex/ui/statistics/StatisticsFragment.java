package com.TheKing.videoplex.ui.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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


public class StatisticsFragment extends Fragment {
    SharedPreferenceUtility sharedPreferenceUtility;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        sharedPreferenceUtility = new SharedPreferenceUtility();

        Video video = sharedPreferenceUtility.GetData(this.getContext());

        Log.d("TheKing--> ", "Inside StatisticsFragment, Video Data size = " + video.getVideoData().size());

        BarChart barChart = view.findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        ArrayList<String> xAxisValues = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i<video.getVideoData().size(); i++){
            Video_Data video_data = video.getVideoData().get(i);
            String category = video_data.getCategory();
            if(!xAxisValues.contains(category)){
                xAxisValues.add(category);
            }

            if(hashMap.get(category) == null){
                hashMap.put(category, 1);
            }else{
                Integer curValue = hashMap.get(category);
                hashMap.put(category, curValue + 1);
            }

        }

        for(int i=0; i<xAxisValues.size(); i++){
            visitors.add(new BarEntry(i, hashMap.get(xAxisValues.get(i))));
        }



        BarDataSet barDataSet = new BarDataSet(visitors, "Statistics of Video Contents");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextSize(16f);
        barDataSet.setValueTextColor(Color.WHITE);


        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.animateY(1000);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisValues));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(xAxisValues.size());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        barChart.getDescription().setEnabled(false);
        barChart.getXAxis().setTextColor(Color.WHITE);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}