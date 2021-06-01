package com.TheKing.videoplex.ui.videos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TheKing.videoplex.R;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalViewHolder> {
    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
        verticalViewHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, verticalModel.getTitle(), Toast.LENGTH_SHORT).show();
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
        Button btnMore;

        public VerticalViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.titleText);
            horizontalRecyclerView = (RecyclerView)itemView.findViewById(R.id.horizontalReciclerView);
            btnMore = (Button)itemView.findViewById(R.id.moreBtn);

        }
    }
}
