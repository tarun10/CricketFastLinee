package com.learning.cricketfastline.FixtureFragment.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cricket.adfreecricketliveline.R;
import com.cricket.adfreecricketliveline.model.MatchWithTitle;
import com.cricket.adfreecricketliveline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class DateWiseRecyclerViewAdapter extends RecyclerView.Adapter<DateWiseRecyclerViewAdapter.TitleViewHolder> {
    private ArrayList<MatchWithTitle> eventTitleViews;
    private Context context;
    private RecyclerItemClickEvent itemClickEvent;

    public DateWiseRecyclerViewAdapter(ArrayList<MatchWithTitle> eventTitleViews, Context context, RecyclerItemClickEvent itemClickEvent) {
        this.eventTitleViews = eventTitleViews;
        this.context = context;
        this.itemClickEvent = itemClickEvent;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heder_recycler_layout, parent, false);
        return new TitleViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {

        MatchWithTitle eventTitleView = eventTitleViews.get(position);
        holder.header_title.setText(eventTitleView.getTitle());
        holder.layout.removeAllViews();
        eventTitleView.getAllMatches().forEach(upcomingEvent -> {
            View itemView = LayoutInflater.from(context).inflate(R.layout.upcoming_recycler_adapter_items, null);
            CardView liveCard = itemView.findViewById(R.id.liveCard);
            TextView teamA = itemView.findViewById(R.id.teamA);
            TextView teamB = itemView.findViewById(R.id.teamB);
            TextView eventName = itemView.findViewById(R.id.eventName);
            ImageView teamAFlag = itemView.findViewById(R.id.teamAFlag);
            ImageView teamBFlag = itemView.findViewById(R.id.teamBFlag);
            TextView match_status_head = itemView.findViewById(R.id.match_status_head);
            TextView favTeam = itemView.findViewById(R.id.favTeam);
            TextView dateTime = itemView.findViewById(R.id.dateTime);
            String matchdate = upcomingEvent.getMatchtime().substring(upcomingEvent.getMatchtime().indexOf("at") + 2, upcomingEvent.getMatchtime().lastIndexOf("-")).trim();
            if (upcomingEvent.getTitle().contains("Test"))
                match_status_head.setText("Status: Upcoming");
            else
                match_status_head.setText("Status: Start at " + matchdate);
            favTeam.setVisibility(View.VISIBLE);
            favTeam.setText("Venue : " + upcomingEvent.getVenue());
            dateTime.setText(upcomingEvent.getTitle());
            teamA.setText(upcomingEvent.getTeamA());
            teamB.setText(upcomingEvent.getTeamB());
            Glide.with(context).load(upcomingEvent.getImageUrl() + upcomingEvent.getTeamAImage()).into(teamAFlag);
            Glide.with(context).load(upcomingEvent.getImageUrl() + upcomingEvent.getTeamBImage()).into(teamBFlag);
            liveCard.setOnClickListener(view -> {
                itemClickEvent.onClick("upcoming", String.valueOf(upcomingEvent.getMatchId()), (upcomingEvent.getTeamA() + " vs " + upcomingEvent.getTeamB()), upcomingEvent.getVenue());
            });
            holder.layout.addView(itemView);
        });

    }

    @Override
    public int getItemCount() {
        return eventTitleViews.size();
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {
        private TextView header_title;
        private LinearLayoutCompat layout;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            header_title = itemView.findViewById(R.id.header_title);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}

