package com.TheKing.videoplex.ui.gridView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.model.Video;
import com.TheKing.videoplex.ui.model.Video_Data;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FilterDialog extends AppCompatDialogFragment {
    ArrayList<String> groupList;
    ArrayList<String> childList;
    HashMap<String, ArrayList<String>> expandableListData;
    HashMap<String, ArrayList<String>> expandableListDataSelected;
    ExpandableListView expandableListView;
    MyExpandableListAdapter expandableListAdapter;
    ImageButton okBtn;
    ImageButton cancelBtn;
    ImageButton clearBtn;

    private FilterDialogListener listener;
    ArrayList<Video_Data> videoData;

    public FilterDialog(ArrayList<Video_Data> videoData, HashMap<String, ArrayList<String>> expandableListDataSelected){
        this.videoData = videoData;
        this.expandableListDataSelected = expandableListDataSelected;
    }


    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(view).setTitle("Filter Videos");

        preProcessExpandableListViewData();

        expandableListView = view.findViewById(R.id.expandable_list_view);
        expandableListAdapter = new MyExpandableListAdapter(getContext(), groupList, expandableListData, expandableListDataSelected);
        expandableListView.setAdapter(expandableListAdapter);

        okBtn = view.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TheKing--> " , "Inside Filter Dialog OK Button Clicked");
                listener.applyFilter();
                dismiss();
            }
        });

        cancelBtn = view.findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        clearBtn = view.findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clearFilter();
                listener.applyFilter();
                dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);

        try {
            listener = (FilterDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must Implement FilterDialogListener");
        }

    }

    private void preProcessExpandableListViewData(){
        groupList = new ArrayList<>();
        groupList.add("Genre");
        groupList.add("Country");
        groupList.add("Language");
        groupList.add("Year");
        ArrayList<String> childList_Genre = new ArrayList<>();
        ArrayList<String> childList_Country = new ArrayList<>();
        ArrayList<String> childList_Language = new ArrayList<>();
        ArrayList<String> childList_Year = new ArrayList<>();

        for(Video_Data x : videoData){
            //Genre
            for(String s: x.getGenre()){
                if(! childList_Genre.contains(s)){
                    childList_Genre.add(s);
                }
            }

            //Country
            for(String s: x.getCountry()){
                if(! childList_Country.contains(s)){
                    childList_Country.add(s);
                }
            }

            //Language
            for(String s: x.getLanguage()){
                if(! childList_Language.contains(s)){
                    childList_Language.add(s);
                }
            }

            //Year
            if(!childList_Year.contains(x.getYear())){
                childList_Year.add(x.getYear());
            }

        }

        Collections.sort(childList_Genre);
        Collections.sort(childList_Country);
        Collections.sort(childList_Language);
        Collections.sort(childList_Year);

        expandableListData = new HashMap<>();
        expandableListData.put("Genre", childList_Genre);
        expandableListData.put("Country", childList_Country);
        expandableListData.put("Language", childList_Language);
        expandableListData.put("Year", childList_Year);

    }

    public interface FilterDialogListener {
        void applyFilter();
        void clearFilter();
    }

}
