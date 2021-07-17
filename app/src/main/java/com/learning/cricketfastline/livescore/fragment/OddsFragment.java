package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.tabs.TabLayout;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.home.viewmodel.Matchst;
import com.learning.cricketfastline.livescore.adapters.OddsAdapter;
import com.learning.cricketfastline.livescore.models.LiveScoreModel;

import java.util.ArrayList;
import java.util.HashMap;


public class OddsFragment extends Fragment {

    private LiveScoreModel liveScoreModel;
    private ArrayList<Matchst> teamAOdds = new ArrayList<>();
    private ArrayList<Matchst> teamBOdds = new ArrayList<>();
    private OddsAdapter oddsAdapter;
    private RecyclerView oddsRecyclerview;
    private TabLayout oddsTabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_odds, container, false);
        oddsRecyclerview = view.findViewById(R.id.oddsRecyclerview);
        oddsTabLayout = view.findViewById(R.id.oddsTabLayout);
        oddsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        liveScoreModel = new ViewModelProvider(this).get(LiveScoreModel.class);
        HashMap<String, String> scoreInfo = new HashMap<>();
        scoreInfo.put("matchId", getActivity().getIntent().getStringExtra("matchId"));
        getHistoryScore(scoreInfo);
        return view;
    }


    private void getHistoryScore(HashMap<String, String> scoreInfo) {
        liveScoreModel.getMatchOddsScoreCard(scoreInfo).observeForever(new Observer<ArrayList<Matchst>>() {
            @Override
            public void onChanged(ArrayList<Matchst> matchsts) {
                Log.d("matchodds", matchsts.get(0).getIsfirstinning());
                for (int i = 0; i < matchsts.size(); i++) {
                    if (matchsts.get(i).getIsfirstinning().equalsIgnoreCase("1")) {
                        teamAOdds.add(matchsts.get(i));
                    } else {
                        teamBOdds.add(matchsts.get(i));
                    }
                }
                oddsAdapter = new OddsAdapter(teamAOdds);
                oddsRecyclerview.setAdapter(oddsAdapter);
            }
        });

        oddsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        oddsAdapter = new OddsAdapter(teamAOdds);
                        oddsRecyclerview.setAdapter(oddsAdapter);
                        break;
                    case 1:
                        oddsAdapter = new OddsAdapter(teamBOdds);
                        oddsRecyclerview.setAdapter(oddsAdapter);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}