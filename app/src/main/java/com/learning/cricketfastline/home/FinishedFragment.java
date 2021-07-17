package com.learning.cricketfastline.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.home.adapters.FinishedRecyclerAdapter;
import com.learning.cricketfastline.home.viewmodel.FinishedViewModel;
import com.learning.cricketfastline.livescore.TabLayoutMainActivity;
import com.learning.cricketfastline.model.MatchWithTitle;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class FinishedFragment extends Fragment implements RecyclerItemClickEvent {

    private FinishedViewModel mViewModel;
    private RecyclerView finishedRecyclerview;

    public static FinishedFragment newInstance() {
        return new FinishedFragment();
    }

    private FinishedRecyclerAdapter finishedRecyclerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.finished_fragment, container, false);
        finishedRecyclerview=view.findViewById(R.id.finishedRecyclerview);
        finishedRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mViewModel = new ViewModelProvider(this).get(FinishedViewModel.class);
        mViewModel.getFinishedData().observe(getViewLifecycleOwner(), new Observer<ArrayList<MatchWithTitle>>() {
            @Override
            public void onChanged(ArrayList<MatchWithTitle> eventTitleViews) {
                finishedRecyclerview.setAdapter(new FinishedRecyclerAdapter(eventTitleViews, getContext(), FinishedFragment.this::onClick));

            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
        startActivity(new Intent(getActivity(), TabLayoutMainActivity.class)
                .putExtra("matchId", matchId)
                .putExtra("matchType", matchType)
                .putExtra("title", title).putExtra("message", message));
    }
}