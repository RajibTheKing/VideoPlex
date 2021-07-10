package com.TheKing.videoplex.ui.gridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.home.VerticalModel;
import com.TheKing.videoplex.ui.home.VerticalRecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GridViewActivity extends AppCompatActivity {
    Gson gson;
    RecyclerView gridRecyclerView;
    GridViewRecyclerViewAdapter gridViewRecyclerViewAdapter;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);




        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        //Get Parameter Value:
        Bundle b = getIntent().getExtras();
        String verticalModelInJson = b.getString("verticalModelInJson");
        String appBarTitle = b.getString("actionBarTitle");

        Toolbar toolbar = (Toolbar) findViewById(R.id.gridViewToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(appBarTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Log.d("TheKing-->", "GridViewActivity verticalModel = " + verticalModelInJson);

        VerticalModel verticalModel = gson.fromJson(verticalModelInJson, VerticalModel.class);


        gridRecyclerView = findViewById(R.id.gridRecylerView);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_intra_space);
        GridLayoutManager gridLayoutManager;

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            gridLayoutManager = new GridLayoutManager(this, 3);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, 3));
        }
        else{
            gridLayoutManager = new GridLayoutManager(this, 4);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, 4));
        }
        gridViewRecyclerViewAdapter = new GridViewRecyclerViewAdapter(this, verticalModel.getArrayList());


        gridRecyclerView.setAdapter(gridViewRecyclerViewAdapter);


        searchView = findViewById(R.id.gridViewSearch);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("TheKing--> ", "onQueryTexhChange: " + newText);
                gridViewRecyclerViewAdapter.getFilter().filter(newText);
                return false;
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }

        });


    }
}