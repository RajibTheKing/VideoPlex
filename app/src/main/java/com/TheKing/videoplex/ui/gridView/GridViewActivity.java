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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.home.VerticalModel;
import com.TheKing.videoplex.ui.home.VerticalRecyclerViewAdapter;
import com.TheKing.videoplex.ui.model.FilterData;
import com.TheKing.videoplex.ui.model.Video_Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class GridViewActivity extends AppCompatActivity implements FilterDialog.FilterDialogListener, MyExpandableListAdapter.MyExpandableListListener {
    Gson gson;
    RecyclerView gridRecyclerView;
    GridViewRecyclerViewAdapter gridViewRecyclerViewAdapter;
    SearchView searchView;

    ImageButton filterBtn;
    ArrayList<Video_Data> videoData;
    HashMap<String, ArrayList<String>> expandableListDataSelected;
    FilterData filterData;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        filterData = new FilterData();

        Log.d("TheKing--> ", "Initializing expandableListDataSelected");
        expandableListDataSelected = new HashMap<>();
        this.clearFilter();




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
        videoData = verticalModel.getArrayList();


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
        gridViewRecyclerViewAdapter = new GridViewRecyclerViewAdapter(this, videoData);


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
                filterData.setSearchQuery(newText);
                filterData.setExtendedData(expandableListDataSelected);
                gridViewRecyclerViewAdapter.getFilter().filter(gson.toJson(filterData).toString());
                return false;
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }

        });


        //TheKing--> Here I am starting to Initialize Expandable List View
        filterBtn = findViewById(R.id.filterBtn);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });





    }

    private void openDialog(){

        FilterDialog filterDialog = new FilterDialog(videoData, expandableListDataSelected);
        filterDialog.show(getSupportFragmentManager(), "Filter Videos");

    }


    @Override
    public void applyFilter() {
        Log.d("TheKign--> ", "FilterData: " + this.expandableListDataSelected.toString());
        filterData.setSearchQuery("");
        filterData.setExtendedData(expandableListDataSelected);
        gridViewRecyclerViewAdapter.getFilter().filter(gson.toJson(filterData).toString());
    }

    @Override
    public void clearFilter() {
        expandableListDataSelected.put("Genre", new ArrayList<>());
        expandableListDataSelected.put("Country", new ArrayList<>());
        expandableListDataSelected.put("Language", new ArrayList<>());
        expandableListDataSelected.put("Year", new ArrayList<>());
        Log.d("TheKing-->", "clearFilter: " + expandableListDataSelected.toString());
    }

    public void OnCheckBoxChanged(String groupName, String childName, boolean isChecked){
        Log.d("TheKing-->", "OnCheckBoxChanged: " + groupName + ", " + childName + ", " + isChecked);

    }
}