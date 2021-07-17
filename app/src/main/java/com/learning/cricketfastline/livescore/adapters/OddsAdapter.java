package com.learning.cricketfastline.livescore.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.home.viewmodel.Matchst;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OddsAdapter extends RecyclerView.Adapter<OddsAdapter.ViewHolder> {
    private ArrayList<Matchst> matchsts;

    public OddsAdapter(ArrayList<Matchst> matchsts) {
        this.matchsts = matchsts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.odds_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matchst matchst = matchsts.get(position);
        holder.score.setText(matchst.getScore());
        holder.overs.setText(matchst.getOvers());
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yyyyyy HH:mm:ss").parse(matchst.getSubdate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String newString = new SimpleDateFormat("HH:mm").format(date);
        holder.subdate.setText(newString);
        holder.sessionAOdds.setText(matchst.getSessionA());
        holder.sessionBOdds.setText(matchst.getSessionB());
        holder.battingteam.setText(matchst.getBattingteam());
        holder.mrateA.setText(matchst.getMrateA());
        holder.mrateB.setText(matchst.getMrateB());
    }

    @Override
    public int getItemCount() {
        return matchsts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView score, overs, subdate, sessionAOdds, sessionBOdds, battingteam, mrateA, mrateB;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            score = itemView.findViewById(R.id.score);
            overs = itemView.findViewById(R.id.overs);

            subdate = itemView.findViewById(R.id.subdate);
            sessionAOdds = itemView.findViewById(R.id.sessionAOdds);

            sessionBOdds = itemView.findViewById(R.id.sessionBOdds);
            battingteam = itemView.findViewById(R.id.battingteam);

            mrateA = itemView.findViewById(R.id.mrateA);
            mrateB = itemView.findViewById(R.id.mrateB);

        }
    }
}
