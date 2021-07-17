package com.learning.cricketfastline.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.learning.cricketfastline.R;
import com.learning.cricketfastline.databinding.FragmentLiveHomeBinding;
import com.learning.cricketfastline.home.adapters.LiveRecyclerAdapter;
import com.learning.cricketfastline.home.viewmodel.LiveFragementViewModel;
import com.learning.cricketfastline.livescore.TabLayoutMainActivity;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;


public class LiveHomeFragment extends Fragment implements RecyclerItemClickEvent {

    private LiveFragementViewModel liveFragementViewModel;
    private FragmentLiveHomeBinding fragmentLiveHomeBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLiveHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_live_home, container, false);
        View view = fragmentLiveHomeBinding.getRoot();
        liveFragementViewModel = new ViewModelProvider(this).get(LiveFragementViewModel.class);
        fragmentLiveHomeBinding.liveRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        liveFragementViewModel.getUpComingData().observeForever(new Observer<ArrayList<LiveMatchModel>>() {
            @Override
            public void onChanged(ArrayList<LiveMatchModel> eventTitleViews) {
                //allHomeFragmentAdapter=new AllHomeFragmentAdapter(eventTitleViews);
                fragmentLiveHomeBinding.liveRecyclerview.setAdapter(new LiveRecyclerAdapter(eventTitleViews, getContext(), LiveHomeFragment.this::onClick));
            }
        });

        return view;
    }

    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
        startActivity(new Intent(getActivity(), TabLayoutMainActivity.class)
                .putExtra("matchId", matchId)
                .putExtra("matchType", matchType)
                .putExtra("title", title)
                .putExtra("message", message));
    }
}