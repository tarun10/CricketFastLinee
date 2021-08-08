package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.adapters.SeriesRecyclerAdapter;
import com.learning.cricketfastline.livescore.models.LiveScoreModel;
import com.learning.cricketfastline.model.stats.MatchStats;

import java.util.HashMap;


public class SeatsFragment extends Fragment {

    private SeriesRecyclerAdapter seriesRecyclerAdapter;
    private RecyclerView match_status;
    private HashMap<String, String> stringStringHashMap = new HashMap<>();
    private LiveScoreModel liveScoreModel;
    private ImageView text;


    public static SeatsFragment getInstance() {
        return new SeatsFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        liveScoreModel = new ViewModelProvider(this).get(LiveScoreModel.class);
        stringStringHashMap.put("MatchId", getActivity().getIntent().getStringExtra("matchId"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        match_status = view.findViewById(R.id.match_status);
        text = view.findViewById(R.id.text);
        match_status.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        liveScoreModel.getMatchStats(stringStringHashMap).observeForever(new Observer<MatchStats>() {
            @Override
            public void onChanged(MatchStats matchsts) {
                if (matchsts != null && matchsts.getMatchst().size() > 0) {
                    match_status.setVisibility(View.VISIBLE);
                    text.setVisibility(View.GONE);
                    seriesRecyclerAdapter = new SeriesRecyclerAdapter(matchsts.getMatchst());
                    match_status.setAdapter(seriesRecyclerAdapter);
                } else {
                    match_status.setVisibility(View.GONE);
                    text.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }
}