package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.adapters.PlayingElevenTeamAAdapter;
import com.learning.cricketfastline.livescore.adapters.PlayingElevenTeamBAdapter;
import com.learning.cricketfastline.livescore.models.LiveScoreModel;
import com.learning.cricketfastline.model.livejsondata.LiveScoreDataModel;
import com.learning.cricketfastline.model.livejsondata.LiveScoreModelJsonRun;
import com.learning.cricketfastline.model.players.Players;
import com.learning.cricketfastline.utility.CommonFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InfoFragment extends Fragment {

    private LiveScoreModel liveScoreModel;
    private ArrayList<Players> teamAPlayers = new ArrayList<>();
    private ArrayList<Players> teamBPlayers = new ArrayList<>();
    private PlayingElevenTeamAAdapter playingElevenAdapter;
    private PlayingElevenTeamBAdapter playingElevenTeamBAdapter;
    private RecyclerView teamArecyclerview, teamBrecyclerview;
    private ConstraintLayout teamARecyclerviewlayout, teamBRecyclerviewlayout, mainLayout;
    private String teamAnme, teamBnme;
    private LinearLayout placeHolder;
    private TextView toss,teamAIX,teamBIX,team1,team2,seriesName,match,dateTime;
    private ImageView team1Image,team2Image,imageView11,imageView12;

    public InfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        mainLayout = view.findViewById(R.id.mainLayout);
        placeHolder = view.findViewById(R.id.placeHolder);
        toss = view.findViewById(R.id.toss);
        teamAIX = view.findViewById(R.id.teamAIX);
        teamBIX = view.findViewById(R.id.teamBIX);
        team1 = view.findViewById(R.id.team1);
        team2 = view.findViewById(R.id.team2);
        seriesName = view.findViewById(R.id.seriesName);
        match = view.findViewById(R.id.match);
        dateTime = view.findViewById(R.id.dateTime);
        team1Image = view.findViewById(R.id.team1Image);
        team2Image = view.findViewById(R.id.team2Image);
        imageView11 = view.findViewById(R.id.imageView11);
        imageView12 = view.findViewById(R.id.imageView12);

        HashMap<String, String> scoreInfo = new HashMap<>();

        scoreInfo.put("matchId", getActivity().getIntent().getStringExtra("matchId"));

        liveScoreModel = new ViewModelProvider(this).get(LiveScoreModel.class);
        teamArecyclerview = view.findViewById(R.id.teamArecyclerview);
        teamBrecyclerview = view.findViewById(R.id.teamBrecyclerview);
        teamARecyclerviewlayout = view.findViewById(R.id.teamARecyclerviewlayout);
        teamBRecyclerviewlayout = view.findViewById(R.id.teamBRecyclerviewlayout);
        if (scoreInfo.get("matchId").equalsIgnoreCase("0")) {
            mainLayout.setVisibility(View.GONE);
            placeHolder.setVisibility(View.VISIBLE);
        } else {
            placeHolder.setVisibility(View.GONE);
            getInfoData(scoreInfo);

        }

        teamARecyclerviewlayout.setOnClickListener(v -> {

            if (teamArecyclerview.getVisibility() == View.GONE) {
                if (teamAPlayers.size() > 1) {
                    teamArecyclerview.setVisibility(View.VISIBLE);
                    int numberOfColumns = 3;
                    teamArecyclerview.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
                    CommonFunction.itemDecoration(getContext());
                    playingElevenAdapter = new PlayingElevenTeamAAdapter(teamAPlayers, getContext());
                    teamArecyclerview.setAdapter(playingElevenAdapter);
                }
            } else if (teamArecyclerview.getVisibility() == View.VISIBLE) {
                teamArecyclerview.setVisibility(View.GONE);
            }


        });


        teamBRecyclerviewlayout.setOnClickListener(v -> {

            if (teamBrecyclerview.getVisibility() == View.GONE) {
                if (teamBPlayers.size() > 1) {
                    teamBrecyclerview.setVisibility(View.VISIBLE);
                    int numberOfColumns = 3;
                    teamBrecyclerview.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
                    playingElevenTeamBAdapter = new PlayingElevenTeamBAdapter(teamBPlayers, getContext());
                    teamBrecyclerview.setAdapter(playingElevenTeamBAdapter);
                }
            } else if (teamBrecyclerview.getVisibility() == View.VISIBLE) {
                teamBrecyclerview.setVisibility(View.GONE);
            }


        });

        return view;
    }

    private void getInfoData(HashMap<String, String> scoreInfo) {
        liveScoreModel.getUpComingData(scoreInfo).observeForever(liveMatchModels -> {
            if (liveMatchModels.size() >= 1) {
                LiveScoreDataModel liveScoreDataModel = new Gson().fromJson(liveMatchModels.get(0).getJsondata(), LiveScoreDataModel.class);
                LiveScoreModelJsonRun liveScoreModelJsonRun = new Gson().fromJson(liveMatchModels.get(0).getJsonruns(), LiveScoreModelJsonRun.class);
                if (liveScoreDataModel != null && liveScoreDataModel.getJsondata() != null) {
                    Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamABanner()).placeholder(R.drawable.logo_dark).into(team1Image);
                    Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamBBanner()).placeholder(R.drawable.logo_dark).into(team2Image);
                    Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamABanner()).placeholder(R.drawable.logo_dark).into(imageView11);
                    Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamBBanner()).placeholder(R.drawable.logo_dark).into(imageView12);
                }
                if (liveScoreModelJsonRun != null && liveScoreModelJsonRun.getJsonruns() != null) {
                    List<String> summary = Arrays.asList(liveScoreModelJsonRun.getJsonruns().getSummary().split("\n"));
                    toss.setText(getToastMessage(summary));
                }
                try {
                    teamAnme = liveScoreDataModel.getJsondata().getTeamA();
                    teamBnme = liveScoreDataModel.getJsondata().getTeamB();
                    teamAIX.setText(teamAnme);
                    teamBIX.setText(teamBnme);
                    team1.setText(teamAnme);
                    team2.setText(teamBnme);
                    seriesName.setText(liveMatchModels.get(0).getVenue());
                    match.setText(liveMatchModels.get(0).getTitle());
                    dateTime.setText(liveMatchModels.get(0).getMatchDate());
                    getLiveDataInfo(scoreInfo);
                } catch (Exception e) {
                }
            } else {
                placeHolder.setVisibility(View.VISIBLE);
                mainLayout.setVisibility(View.GONE);
            }
        });
    }

    private String getToastMessage(List list) {
        String message = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("toss")) {
                message = list.get(i).toString();
            }
        }
        return message;
    }

    private void getLiveDataInfo(HashMap<String, String> scoreInfo) {
        liveScoreModel.getPlayerInfo(scoreInfo).observeForever(players -> {
            for (int i = 0; i < players.size(); i++) {
                if ((players.get(i).getInning().equals(1)) && players.get(i).getTeamName().equalsIgnoreCase(teamAnme)) {
                    teamAPlayers.add(players.get(i));
                } else {
                    if (players.get(i).getInning().equals(1) && players.get(i).getTeamName().equalsIgnoreCase(teamBnme))
                        teamBPlayers.add(players.get(i));
                }
            }
        });
    }

}