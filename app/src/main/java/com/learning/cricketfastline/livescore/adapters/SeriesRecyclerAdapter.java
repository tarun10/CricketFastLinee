package com.learning.cricketfastline.livescore.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.stats.Matchst;

import java.util.List;

public class SeriesRecyclerAdapter extends RecyclerView.Adapter<SeriesRecyclerAdapter.ViewHolder> {
    private List<Matchst> matchst;

    public SeriesRecyclerAdapter(List<Matchst> matchst) {
        this.matchst = matchst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.match_preview.setText(Html.fromHtml(matchst.get(position).getStat1descr()));
        holder.pitch_status.setText(Html.fromHtml(matchst.get(position).getStat2descr()));
        holder.stats.setText(Html.fromHtml(matchst.get(position).getStat3descr()));
    }

    @Override
    public int getItemCount() {
        return matchst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView match_preview;
        private TextView pitch_status;
        private TextView stats;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            match_preview = itemView.findViewById(R.id.match_preview);
            pitch_status = itemView.findViewById(R.id.pitch_status);
            stats = itemView.findViewById(R.id.stats);
        }
    }
}