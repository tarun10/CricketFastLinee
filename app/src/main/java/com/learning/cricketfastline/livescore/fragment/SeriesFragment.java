package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.adapters.SeriesRecyclerAdapter;


public class SeriesFragment extends Fragment {

    private SeriesRecyclerAdapter seriesRecyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        recyclerView = view.findViewById(R.id.series_status);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        seriesRecyclerAdapter=new SeriesRecyclerAdapter();
        recyclerView.setAdapter(seriesRecyclerAdapter);
        return view;
    }
}