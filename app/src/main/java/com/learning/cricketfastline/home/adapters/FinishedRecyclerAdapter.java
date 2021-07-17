package com.learning.cricketfastline.home.adapters;

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
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.MatchWithTitle;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class FinishedRecyclerAdapter extends RecyclerView.Adapter<FinishedRecyclerAdapter.TitleViewHolder> {
    private ArrayList<MatchWithTitle> eventTitleViews;
    private Context context;
    private RecyclerItemClickEvent itemClickEvent;

    public FinishedRecyclerAdapter(ArrayList<MatchWithTitle> eventTitleViews, Context context, RecyclerItemClickEvent itemClickEvent) {
        super();
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
            View itemView = LayoutInflater.from(context).inflate(R.layout.items_recycler_layout, null);
            CardView liveCard = itemView.findViewById(R.id.liveCard);
            TextView title = itemView.findViewById(R.id.title);
            TextView teamA = itemView.findViewById(R.id.teamA);
            TextView teamARun = itemView.findViewById(R.id.teamARun);
            TextView teamAOver = itemView.findViewById(R.id.teamAOver);
            TextView teamB = itemView.findViewById(R.id.teamB);
            TextView teamBRun = itemView.findViewById(R.id.teamBRun);
            TextView teamBOver = itemView.findViewById(R.id.teamBOver);
            TextView eventName = itemView.findViewById(R.id.eventName);
            TextView match_status_sub = itemView.findViewById(R.id.match_status_sub);
            TextView match_status_head = itemView.findViewById(R.id.match_status_head);
            ImageView teamAFlag = itemView.findViewById(R.id.teamAFlag);
            ImageView teamBFlag = itemView.findViewById(R.id.teamBFlag);
            eventName.setText(upcomingEvent.getTitle());
            teamA.setText(upcomingEvent.getTeamA());
            teamB.setText(upcomingEvent.getTeamB());
            Glide.with(context).load(upcomingEvent.getImageUrl() + upcomingEvent.getTeamAImage()).into(teamAFlag);
            Glide.with(context).load(upcomingEvent.getImageUrl() + upcomingEvent.getTeamBImage()).into(teamBFlag);

            //teamBOver.setText(upcomingEvent.getT2CurOvr());
            //teamBRun.setText(upcomingEvent.getT2Rn() + " / " + upcomingEvent.getT2Wkt());
            //teamARun.setText(upcomingEvent.getT1Rn() + " / " + upcomingEvent.getT1Wkt());
            //teamAOver.setText(upcomingEvent.getT1CurOvr());
            match_status_head.setText(upcomingEvent.getResult());

            liveCard.setOnClickListener(view -> {
                itemClickEvent.onClick("finished", String.valueOf(upcomingEvent.getMatchId()),
                        (upcomingEvent.getTeamA() + " vs " + upcomingEvent.getTeamB()),
                        upcomingEvent.getResult());
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
