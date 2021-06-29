package com.TheKing.videoplex.ui.gridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.home.VerticalModel;
import com.TheKing.videoplex.ui.home.VerticalRecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GridViewActivity extends AppCompatActivity {
    Gson gson;
    RecyclerView gridRecyclerView;
    GridViewRecyclerViewAdapter gridViewRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);



        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        //Get Parameter Value:
        Bundle b = getIntent().getExtras();
        String verticalModelInJson = b.getString("verticalModelInJson");

        //Log.d("TheKing-->", "GridViewActivity verticalModel = " + verticalModelInJson);

        VerticalModel verticalModel = gson.fromJson(verticalModelInJson, VerticalModel.class);


        gridRecyclerView = findViewById(R.id.gridRecylerView);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        gridViewRecyclerViewAdapter = new GridViewRecyclerViewAdapter(this, verticalModel.getArrayList());
        gridRecyclerView.setAdapter(gridViewRecyclerViewAdapter);

    }
}