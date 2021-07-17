package com.learning.cricketfastline.pointtable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.seriesdata.Pointsst;

import java.util.ArrayList;

public class PointTableAdapter extends RecyclerView.Adapter<PointTableAdapter.MyViewHolder>{
    ArrayList<Pointsst> pointTableModels;

    public PointTableAdapter(ArrayList<Pointsst> pointTableModels) {
        this.pointTableModels = pointTableModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poitns_table_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.teams.setText(pointTableModels.get(position).getTeamName());
        holder.match.setText(""+pointTableModels.get(position).getMatches());
        holder.win.setText(""+pointTableModels.get(position).getWon());
        holder.lose.setText(""+pointTableModels.get(position).getLost());
        holder.nr.setText(""+pointTableModels.get(position).getNr());
        holder.pts.setText(""+pointTableModels.get(position).getPts());
        holder.nrr.setText(pointTableModels.get(position).getNrr());

    }

    @Override
    public int getItemCount() {
        return pointTableModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView teams,match,win,lose,nr,pts,nrr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            teams = itemView.findViewById(R.id.pointsteams);
            match = itemView.findViewById(R.id.pointsmatch);
            win = itemView.findViewById(R.id.pointswin);
            lose = itemView.findViewById(R.id.pointslose);
            nr = itemView.findViewById(R.id.pointsnr);
            pts = itemView.findViewById(R.id.pointspts);
            nrr = itemView.findViewById(R.id.pointsnrr);
        }
    }
}
