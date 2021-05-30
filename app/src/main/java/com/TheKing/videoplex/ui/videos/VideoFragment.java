package com.TheKing.videoplex.ui.videos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList arrayList;
    //https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        // Inflate the layout for this fragment
        new JsonData(this).execute("https://raw.githubusercontent.com/RajibTheKing/VideoPlex_Data/master/Artist.json");


        //return startRecyclerView(view);
        return view;
    }

    public void setDataInRecyclerView(Artist artist){

        HelperAdapter helperAdapter = new HelperAdapter(getContext(), artist.ArtistData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(helperAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}