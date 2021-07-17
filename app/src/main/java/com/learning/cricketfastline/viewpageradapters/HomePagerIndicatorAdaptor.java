package com.learning.cricketfastline.viewpageradapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.model.livejsondata.LiveScoreDataModel;
import com.learning.cricketfastline.model.livejsondata.LiveScoreModelJsonRun;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePagerIndicatorAdaptor extends RecyclerView.Adapter<HomePagerIndicatorAdaptor.HeaderView> {


    private ArrayList<LiveMatchModel> eventTitleViews;
    private Context context;
    private RecyclerItemClickEvent itemClickEvent;

    public HomePagerIndicatorAdaptor(ArrayList<LiveMatchModel> eventTitleViews, Context context, RecyclerItemClickEvent itemClickEvent) {
        this.eventTitleViews = eventTitleViews;
        this.context = context;
        this.itemClickEvent = itemClickEvent;
    }

    @NonNull
    @Override
    public HeaderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_header, parent, false);
        return new HeaderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeaderView holder, int position) {
        LiveScoreDataModel liveScoreDataModel = new Gson().fromJson(eventTitleViews.get(position).getJsondata(), LiveScoreDataModel.class);
        LiveScoreModelJsonRun liveScoreModelJsonRun = new Gson().fromJson(eventTitleViews.get(position).getJsonruns(), LiveScoreModelJsonRun.class);

        if (eventTitleViews.get(position).getMatchType().equalsIgnoreCase("test")) {
            holder.constraintLayoutHeaderSession.setVisibility(View.INVISIBLE);
            if (liveScoreModelJsonRun != null && liveScoreModelJsonRun.getJsonruns() != null) {
                List<String> summary = Arrays.asList(liveScoreModelJsonRun.getJsonruns().getSummary().split("\n"));
                holder.favTeamHeader.setText(getDay(summary));
            }
        } else {
            if (liveScoreDataModel != null && liveScoreDataModel.getJsondata() != null) {
                String favteam = liveScoreDataModel.getJsondata().getRateA().substring(liveScoreDataModel.getJsondata().getRateA().lastIndexOf("|") + 1);
                holder.favTeamHeader.setText("Fav - " + favteam);
                String[] rates = liveScoreDataModel.getJsondata().getRateA().substring(0, liveScoreDataModel.getJsondata().getRateA().indexOf("|")).split("-");
                holder.rateATextView.setText(rates[0]);
                holder.rateBTextView.setText(rates[1]);
            }
        }
        if (liveScoreDataModel != null && liveScoreDataModel.getJsondata() != null) {
            holder.match_over.setText("Over (" + liveScoreDataModel.getJsondata().getOversA() + ")");
            Glide.with(context).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamABanner()).circleCrop().into(holder.teamAFlag);
            Glide.with(context).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamBBanner()).circleCrop().into(holder.teamBFlag);
        } else {
            Glide.with(context).load(eventTitleViews.get(position).getImgeURL() + eventTitleViews.get(position).getTeamAImage()).circleCrop().into(holder.teamAFlag);
            Glide.with(context).load(eventTitleViews.get(position).getImgeURL() + eventTitleViews.get(position).getTeamBImage()).circleCrop().into(holder.teamBFlag);
        }

        holder.teamAscore.setText(liveScoreDataModel != null ? liveScoreDataModel.getJsondata().getWicketA() : "");
        holder.teamBscore.setText(liveScoreDataModel != null ? liveScoreDataModel.getJsondata().getWicketB() : "");
        holder.teamA.setText(eventTitleViews.get(position).getTeamA());
        holder.teamB.setText(eventTitleViews.get(position).getTeamB());
        holder.gameName.setText(eventTitleViews.get(position).getTitle());

        if (liveScoreDataModel != null && !liveScoreDataModel.getJsondata().getBowler().equals("0")) {
            holder.match_status.setText("LIVE");
            holder.match_status.setTextColor(ContextCompat.getColor(context, R.color.red));
        } else if (!eventTitleViews.get(position).getResult().equals("")) {
            holder.match_status.setText("Finished");
            holder.match_over.setText(eventTitleViews.get(position).getResult());
            //holder.match_status.setTextColor(ContextCompat.getColor(context, R.color.left_session));
        } else {
            holder.match_status.setText("Upcoming");
            holder.match_over.setText(eventTitleViews.get(position).getMatchtime());
        }
        holder.liveCard.setOnClickListener(view -> {
            itemClickEvent.onClick("live", eventTitleViews.get(position).getMatchId().toString(),
                    (eventTitleViews.get(position).getTeamA() + " vs " + eventTitleViews.get(position).getTeamB()),
                    eventTitleViews.get(position).getMatchType());
        });

    }

    @Override
    public int getItemCount() {
        return eventTitleViews.size();
    }

    public class HeaderView extends RecyclerView.ViewHolder {
        TextView teamA, teamB, match_status, teamAscore, teamBscore, match_over, rateATextView, rateBTextView, gameName, favTeamHeader;
        ImageView teamAFlag, teamBFlag;
        ConstraintLayout liveCard, constraintLayoutHeaderSession;

        public HeaderView(@NonNull View itemView) {
            super(itemView);
            teamA = itemView.findViewById(R.id.teamA);
            teamB = itemView.findViewById(R.id.teamB);
            teamAFlag = itemView.findViewById(R.id.teamAFlag);
            teamBFlag = itemView.findViewById(R.id.teamBFlag);
            match_status = itemView.findViewById(R.id.match_status);
            liveCard = itemView.findViewById(R.id.liveCard);
            teamAscore = itemView.findViewById(R.id.teamAscore);
            teamBscore = itemView.findViewById(R.id.teamBscore);
            match_over = itemView.findViewById(R.id.match_over);

            rateATextView = itemView.findViewById(R.id.rateATextView);
            rateBTextView = itemView.findViewById(R.id.rateBTextView);
            gameName = itemView.findViewById(R.id.gameName);
            favTeamHeader = itemView.findViewById(R.id.favTeamHeader);
            constraintLayoutHeaderSession = itemView.findViewById(R.id.constraintLayoutHeaderSession);

        }
    }

    private String getDay(List list) {
        String message = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("Day")) {
                message = list.get(i).toString();
            }
        }
        return message;
    }

}
