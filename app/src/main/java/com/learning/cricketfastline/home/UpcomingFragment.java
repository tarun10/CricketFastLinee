package com.learning.cricketfastline.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.home.adapters.UpCominingAdapter;
import com.learning.cricketfastline.home.viewmodel.UpComingViewModel;
import com.learning.cricketfastline.model.MatchWithTitle;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;


public class UpcomingFragment extends Fragment implements RecyclerItemClickEvent {

    private RecyclerView upcomingRecyclerView;
    private UpComingViewModel mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.upcoming_fragement, container, false);
        upcomingRecyclerView=view.findViewById(R.id.upcomingRecyclerView);
        init();
        return view;
    }

    private void init() {
        mViewModel = new ViewModelProvider(this).get(UpComingViewModel.class);

        upcomingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mViewModel.getUpComingData().observeForever(new Observer<ArrayList<MatchWithTitle>>() {
            @Override
            public void onChanged(ArrayList<MatchWithTitle> eventTitleViews) {
                upcomingRecyclerView.setAdapter(new UpCominingAdapter(eventTitleViews, getContext(), UpcomingFragment.this::onClick));
            }
        });
    }

    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
       /* startActivity(new Intent(getActivity(), TabLayoutMainActivity.class)
                .putExtra("matchId", matchId)
                .putExtra("matchType", matchType)
                .putExtra("title", title).putExtra("message", message));*/
    }

}