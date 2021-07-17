package com.learning.cricketfastline.FixtureFragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cricket.adfreecricketliveline.R;
import com.cricket.adfreecricketliveline.model.seriesdata.LiveSeries;
import com.cricket.adfreecricketliveline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class SeriesWiseRecyclerViewAdapter extends RecyclerView.Adapter<SeriesWiseRecyclerViewAdapter.ViewHolder> {
    private Context activity;
    private ArrayList<LiveSeries> liveSeries;
    private RecyclerItemClickEvent itemClickEvent;

    public SeriesWiseRecyclerViewAdapter(Context activity, ArrayList<LiveSeries> liveSeries, RecyclerItemClickEvent itemClickEvent) {
        this.activity = activity;
        this.liveSeries = liveSeries;
        this.itemClickEvent = itemClickEvent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_wise_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.seriesDate.setText(liveSeries.get(position).getStartdate());
        holder.seriesName.setText(liveSeries.get(position).getSeriesname());
        holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickEvent.onClick("", liveSeries.get(position).getSeriesid().toString(), liveSeries.get(position).getSeriesname(), "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return liveSeries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView seriesName, seriesDate;
        private LinearLayoutCompat itemClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            seriesDate = itemView.findViewById(R.id.seriesDate);
            seriesName = itemView.findViewById(R.id.seriesName);
            itemClick = itemView.findViewById(R.id.itemClick);
        }
    }
}