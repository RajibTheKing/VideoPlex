package com.TheKing.videoplex.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;
import com.TheKing.videoplex.ui.gridView.GridViewActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalViewHolder> {
    Context context;
    ArrayList<VerticalModel> arrayList;
    Gson gson;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    @NonNull
    @NotNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item, parent, false);
        VerticalViewHolder verticalViewHolder = new VerticalViewHolder(view);
        return verticalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VerticalViewHolder holder, int position) {
        VerticalViewHolder verticalViewHolder = (VerticalViewHolder)holder;
        VerticalModel verticalModel = arrayList.get(position);
        verticalViewHolder.textView.setText(verticalModel.getTitle());

        YoYo.with(Techniques.RubberBand)
                .duration(2000)
                .repeat(Animation.INFINITE)
                .playOn(verticalViewHolder.btnMore);
        verticalViewHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, verticalModel.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, GridViewActivity.class);
                String verticalModelInJson = gson.toJson(verticalModel);
                intent.putExtra("verticalModelInJson", verticalModelInJson);
                intent.putExtra("actionBarTitle", verticalModel.getTitle());
                context.startActivity(intent);
            }
        });

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(context, verticalModel.getArrayList());
        verticalViewHolder.horizontalRecyclerView.setHasFixedSize(true);
        verticalViewHolder.horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        verticalViewHolder.horizontalRecyclerView.setAdapter(horizontalRecyclerViewAdapter);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView horizontalRecyclerView;
        ImageButton btnMore;

        public VerticalViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.titleText);
            horizontalRecyclerView = (RecyclerView)itemView.findViewById(R.id.horizontalReciclerView);
            btnMore = (ImageButton)itemView.findViewById(R.id.moreBtn);

        }
    }
}
