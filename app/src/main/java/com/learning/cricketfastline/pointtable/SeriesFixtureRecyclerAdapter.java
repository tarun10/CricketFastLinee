package com.learning.cricketfastline.pointtable;

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
import com.google.gson.Gson;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.model.livejsondata.LiveScoreDataModel;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class SeriesFixtureRecyclerAdapter extends RecyclerView.Adapter<SeriesFixtureRecyclerAdapter.TitleViewHolder> {
    private ArrayList<LiveMatchModel> eventTitleViews;
    private Context context;
    private RecyclerItemClickEvent itemClickEvent;

    public SeriesFixtureRecyclerAdapter(ArrayList<LiveMatchModel> eventTitleViews, Context context, RecyclerItemClickEvent itemClickEvent) {
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

        holder.header_title.setText(eventTitleViews.get(position).getTitle());
        holder.header_title.setVisibility(View.GONE);
        holder.layout.removeAllViews();
        holder.layout.addView(getLiveInfo(eventTitleViews.get(position)));

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private View getLiveInfo(LiveMatchModel upcomingEvent) {
        LiveScoreDataModel liveScoreDataModel = new Gson().fromJson(upcomingEvent.getJsondata(), LiveScoreDataModel.class);
        View itemView = LayoutInflater.from(context).inflate(R.layout.upcoming_recycler_adapter_items, null);
        CardView liveCard = itemView.findViewById(R.id.liveCard);
        TextView teamA = itemView.findViewById(R.id.teamA);
        TextView teamB = itemView.findViewById(R.id.teamB);
        TextView eventName = itemView.findViewById(R.id.eventName);
        TextView favTeam = itemView.findViewById(R.id.favTeam);
        ImageView teamAFlag = itemView.findViewById(R.id.teamAFlag);
        ImageView teamBFlag = itemView.findViewById(R.id.teamBFlag);
        TextView dateTime = itemView.findViewById(R.id.dateTime);


        TextView match_status_sub = itemView.findViewById(R.id.match_status_sub);
        TextView match_status_head = itemView.findViewById(R.id.match_status_head);
        //match_status_sub.setText(TimeUtility.getStartTime(upcomingEvent.getmTm()));
        dateTime.setText("Date :" + upcomingEvent.getMatchDate());
        teamA.setText(upcomingEvent.getTeamA());
        teamB.setText(upcomingEvent.getTeamB());
        eventName.setText(upcomingEvent.getTitle());
        favTeam.setVisibility(View.VISIBLE);
        if (liveScoreDataModel != null && !liveScoreDataModel.getJsondata().getBowler().equals("0")) {
            match_status_head.setText("Status: LIVE");
            favTeam.setText("Venue : " + upcomingEvent.getVenue());

        } else if (!upcomingEvent.getResult().equals("")) {
            favTeam.setText("Result : " + upcomingEvent.getResult());
            match_status_head.setText("Status: Finished");
        } else {
            String matchdate = upcomingEvent.getMatchtime().substring(upcomingEvent.getMatchtime().indexOf("at") + 2, upcomingEvent.getMatchtime().lastIndexOf("-")).trim();
            match_status_head.setText("Status: Start at " + matchdate);
            favTeam.setText("Venue : " + upcomingEvent.getVenue());
            favTeam.setText(upcomingEvent.getVenue());
        }


        Glide.with(context).load(upcomingEvent.getImgeURL() + upcomingEvent.getTeamAImage()).into(teamAFlag);
        Glide.with(context).load(upcomingEvent.getImgeURL() + upcomingEvent.getTeamBImage()).into(teamBFlag);
        liveCard.setOnClickListener(view -> {
            itemClickEvent.onClick("live", upcomingEvent.getMatchId().toString(), (upcomingEvent.getTeamA() + " vs " + upcomingEvent.getTeamB()), upcomingEvent.getVenue());
        });
        return itemView;
    }

}
