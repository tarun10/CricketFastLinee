package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.adapters.ScoreBastmanAdapter;
import com.learning.cricketfastline.livescore.models.ScoreCardViewModel;
import com.learning.cricketfastline.model.players.Players;
import com.learning.cricketfastline.utility.CommonFunction;

import java.util.ArrayList;
import java.util.HashMap;


public class ScorecardFragment extends Fragment {

    private RecyclerView scoreRecycleView, secondInning;
    private ScoreBastmanAdapter scoreBastmanAdapter, seccondInningAdapter;
    private ScoreCardViewModel scoreCardViewModel;
    private ArrayList<Players> teamAPlayers = new ArrayList<>();
    private ArrayList<Players> teamBPlayers = new ArrayList<>();
    private ArrayList<Players> teamAPlayersSecondInning = new ArrayList<>();
    private ArrayList<Players> teamBPlayersSecondInning = new ArrayList<>();
    private TextView inningFirstScore, inningSecondScore;
    TabLayout tablayoutScorecard;
    LinearLayout playersRunLayout;
    TextView PlayerRunPlaceholder;
    private LinearLayoutCompat secondInningHeader;
    private RelativeLayout firstInningHeader;
    private String matchType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scorecard, container, false);
        inningFirstScore = view.findViewById(R.id.inningFirstScore);
        inningSecondScore = view.findViewById(R.id.inningSecondScore);
        scoreRecycleView = view.findViewById(R.id.scoreRecycleView);
        secondInning = view.findViewById(R.id.secondInning);
        secondInningHeader = view.findViewById(R.id.secondInningHeader);
        firstInningHeader = view.findViewById(R.id.firstInningHeader);

        tablayoutScorecard = view.findViewById(R.id.tablayoutScorecard);
        PlayerRunPlaceholder = view.findViewById(R.id.PlayerRunPlaceholder);
        playersRunLayout = view.findViewById(R.id.playersRunLayout);
        scoreCardViewModel = new ViewModelProvider(this).get(ScoreCardViewModel.class);
        HashMap<String, String> scoreInfo = new HashMap<>();
        scoreInfo.put("MatchId", getActivity().getIntent().getStringExtra("matchId"));
        matchType=getActivity().getIntent().getStringExtra("message");
        if(matchType.equalsIgnoreCase("Test")){
            secondInningHeader.setVisibility(View.VISIBLE);
            firstInningHeader.setVisibility(View.VISIBLE);
        }

        scoreRecycleView.addItemDecoration(CommonFunction.itemDecoration(getContext()));

        secondInning.addItemDecoration(CommonFunction.itemDecoration(getContext()));

        scoreRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        secondInning.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        scoreCardViewModel.getUpComingData(scoreInfo).observeForever(new Observer<ArrayList<Players>>() {
            @Override
            public void onChanged(ArrayList<Players> players) {
                if (players.size() > 1) {
                    playersRunLayout.setVisibility(View.VISIBLE);
                    PlayerRunPlaceholder.setVisibility(View.GONE);
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).getTeamSide().equalsIgnoreCase("Team A")) {
                            if (players.get(i).getInning().equals(1))
                                teamAPlayers.add(players.get(i));
                            else
                                teamAPlayersSecondInning.add(players.get(i));
                        } else {
                            if (players.get(i).getInning().equals(1)) {
                                teamBPlayers.add(players.get(i));
                            } else {
                                teamBPlayersSecondInning.add(players.get(i));
                            }
                        }
                    }
                    tablayoutScorecard.getTabAt(0).setText(teamAPlayers.get(0).getTeamName());
                    tablayoutScorecard.getTabAt(1).setText(teamBPlayers.get(0).getTeamName());
                    setFirstIng();


                } else {
                    PlayerRunPlaceholder.setVisibility(View.VISIBLE);
                    playersRunLayout.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
                }

            }

        });

        tablayoutScorecard.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        setFirstIng();
                        break;
                    case 1:
                        setSecondIng();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;

    }

    private void setFirstIng() {
        scoreBastmanAdapter = new ScoreBastmanAdapter(teamAPlayers, getActivity());
        scoreRecycleView.setAdapter(scoreBastmanAdapter);
        seccondInningAdapter = new ScoreBastmanAdapter(teamAPlayersSecondInning, getActivity());
        secondInning.setAdapter(seccondInningAdapter);
        inningFirstScore.setText(setRuns(teamAPlayers.get(0).getTeamRuns()));
        if (teamAPlayersSecondInning.size() > 0)
            inningSecondScore.setText(setRuns(teamAPlayersSecondInning.get(0).getTeamRuns()));
        else inningSecondScore.setText("0");
    }

    private void setSecondIng() {
        scoreBastmanAdapter = new ScoreBastmanAdapter(teamBPlayers, getActivity());
        scoreRecycleView.setAdapter(scoreBastmanAdapter);
        seccondInningAdapter = new ScoreBastmanAdapter(teamBPlayersSecondInning, getActivity());
        secondInning.setAdapter(seccondInningAdapter);
        inningFirstScore.setText(setRuns(teamBPlayers.get(0).getTeamRuns()));
        if (teamBPlayersSecondInning.size() > 0)
            inningSecondScore.setText(setRuns(teamBPlayersSecondInning.get(0).getTeamRuns()));
        else inningSecondScore.setText("0");
    }

    private String setRuns(String teamRuns) {
        if (teamRuns != null)
            return teamRuns;
        else return "";
    }
}