package com.learning.cricketfastline.livescore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.players.Players;

import java.util.ArrayList;

public class PlayingElevenTeamAAdapter extends RecyclerView.Adapter<PlayingElevenTeamAAdapter.ViewHolder> {
    private ArrayList<Players> playersArrayList;
    private Context context;

    public PlayingElevenTeamAAdapter(ArrayList<Players> playersArrayList, Context context) {
        this.playersArrayList = playersArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playingeleventeamaitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Players players=playersArrayList.get(position);
        String imageUrl = "http://cricnet.co.in/manageplaying/playerimage/";
        holder.playerName.setText(players.getPlayerName());
        Glide.with(context).load(imageUrl+players.getPlayerImage()).placeholder(R.drawable.logo_dark).into(holder.imageViewPlayer);
    }

    @Override
    public int getItemCount() {
        return playersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName;
        private ImageView imageViewPlayer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.playerName);
            imageViewPlayer = itemView.findViewById(R.id.imageViewPlayer);

        }
    }
}

