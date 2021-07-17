package com.learning.cricketfastline.livescore.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.players.Players;
import com.learning.cricketfastline.utility.TimeUtility;

import java.util.ArrayList;

public class ScoreBastmanAdapter extends RecyclerView.Adapter<ScoreBastmanAdapter.ViewHolder> {
    private ArrayList<Players> playersArrayList;
    private Context mContext;

    public ScoreBastmanAdapter(ArrayList<Players> playersArrayList,Context mContext) {
        this.playersArrayList = playersArrayList;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bestman_adapter, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Players players = playersArrayList.get(position);
        holder.bastManName.setText(players.getPlayerName());
        holder.runs.setText(players.getRuns().toString());
        holder.balls.setText(players.getBalls().toString());
        holder.fours.setText(players.getFour().toString());
        holder.sixes.setText(players.getSix().toString());
        holder.runRate.setText(TimeUtility.getStrickRate(players.getRuns().toString(), players.getBalls().toString()));
        if (!players.getOutby().equals("") || !players.getOutby().equals("not out")) {
            holder.outBY.setVisibility(View.VISIBLE);
            holder.outBY.setText(players.getOutby());
        }
        if (players.getOutby().equals("not out") ||players.getOutby().equals("batting") ) {
            holder.bastmanScore.setBackgroundColor(mContext.getResources().getColor(R.color.header_colour));
        } else {
            holder.bastmanScore.setBackgroundColor(mContext.getResources().getColor(R.color.yet_background));
        }
    }

    @Override
    public int getItemCount() {
        return playersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bastManName;
        private TextView runs;
        private TextView balls;
        private TextView fours;
        private TextView sixes;
        private TextView runRate;
        private TextView outBY;
        private LinearLayoutCompat bastmanScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bastManName = itemView.findViewById(R.id.bastmanName);
            runs = itemView.findViewById(R.id.run);
            balls = itemView.findViewById(R.id.ball);
            fours = itemView.findViewById(R.id.fours);
            sixes = itemView.findViewById(R.id.sixes);
            runRate = itemView.findViewById(R.id.runrates);
            outBY = itemView.findViewById(R.id.outBY);
            bastmanScore = itemView.findViewById(R.id.bastmanScore);
        }
    }
}
