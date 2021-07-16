package com.TheKing.videoplex.ui.gridView;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.TheKing.videoplex.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private HashMap<String, ArrayList<String>> expandableListData;
    private ArrayList<String> groupList;
    HashMap<String, ArrayList<String>> expandableListDataSelected;

    private MyExpandableListListener listener;


    public MyExpandableListAdapter(Context context, ArrayList<String> groupList, HashMap<String, ArrayList<String>> expandableListData, HashMap<String, ArrayList<String>> expandableListDataSelected) {
        this.context = context;
        this.expandableListData = expandableListData;
        this.groupList = groupList;
        this.expandableListDataSelected = expandableListDataSelected;

        try {
            listener = (MyExpandableListListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must Implement MyExpandableListListener");
        }
    }


    @Override
    public int getGroupCount() {
        return expandableListData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return expandableListData.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return expandableListData.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupName = getGroup(groupPosition).toString();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_group_item, null);
        }
        TextView item = convertView.findViewById(R.id.expandableGroupItemText);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(groupName);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childName = getChild(groupPosition, childPosition).toString();
        String groupName = getGroup(groupPosition).toString();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_child_item, null);
        }
        TextView item = convertView.findViewById(R.id.expandableChildItemText);
        item.setText(childName);

        CheckBox checkBox = convertView.findViewById(R.id.expandableChildCheckbox);

        Log.d("TheKing--> ", "Check expandableListData: " + expandableListDataSelected.toString());
        checkBox.setOnCheckedChangeListener(null);
        if(expandableListDataSelected.get(groupName).contains(childName)){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                   if(isChecked){
                       Log.d("TheKing-->", " Check box isChecked : " + groupName + ", " + childName);
                       expandableListDataSelected.get(groupName).add(childName);

                   }else{
                       Log.d("TheKing-->", "NOT SELECTED: " + groupName + ", " + childName);
                       expandableListDataSelected.get(groupName).remove(childName);
                   }

                   listener.OnCheckBoxChanged(groupName, childName, isChecked);

               }
           }
        );

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public interface MyExpandableListListener {
        void OnCheckBoxChanged(String groupName, String childName, boolean isChecked);
    }
}
