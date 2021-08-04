package com.learning.cricketfastline;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.livescore.TabLayoutMainActivity;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;
import com.learning.cricketfastline.viewpageradapters.HomeFragementViewModel;
import com.learning.cricketfastline.viewpageradapters.HomePagerIndicatorAdaptor;
import com.learning.cricketfastline.viewpageradapters.HomeViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements RecyclerItemClickEvent {


    TabLayout tabLayout, taindicator;
    ViewPager2 viewPager2, headerViewPager;
    HomeViewPagerAdapter fragmentAdapter;
    private String[] tabHeading = {"Live", "Upcoming", "Finished", "Series"};
    private HomeFragementViewModel homeFragementViewModel;
    private SpringDotsIndicator dotsIndicator;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        tabLayout = view.findViewById(R.id.tabLayout);
        //taindicator = view.findViewById(R.id.taindicator);
        viewPager2 = view.findViewById(R.id.viewPager2);
        headerViewPager = view.findViewById(R.id.headerViewPager);
        viewPager2.setOffscreenPageLimit(2);
        headerViewPager.setOffscreenPageLimit(3);
        dotsIndicator = view.findViewById(R.id.dotsss);
        fragmentAdapter = new HomeViewPagerAdapter(getActivity());
        viewPager2.setAdapter(fragmentAdapter);
        homeFragementViewModel = new ViewModelProvider(this).get(HomeFragementViewModel.class);
        loadeHeaderData();

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabHeading[position])).attach();


        return view;
    }

    private void loadeHeaderData() {
        homeFragementViewModel.getUpComingData().observeForever(new Observer<ArrayList<LiveMatchModel>>() {
            @Override
            public void onChanged(ArrayList<LiveMatchModel> eventTitleViews) {
                if(!eventTitleViews.get(1).getTitle().contains("adsbanner"))
                eventTitleViews.add(1,new LiveMatchModel("adsbanner","drawable://" + R.drawable.adsbanner));
                HomePagerIndicatorAdaptor homePagerIndicatorAdaptor = new HomePagerIndicatorAdaptor(eventTitleViews, getContext(), HomeFragment.this::onClick);
                headerViewPager.setAdapter(homePagerIndicatorAdaptor);
                dotsIndicator.setViewPager2(headerViewPager);
            }
        });
    }


    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
        startActivity(new Intent(getActivity(), TabLayoutMainActivity.class)
                .putExtra("matchId", matchId)
                .putExtra("matchType", matchType)
                .putExtra("title", title)
                .putExtra("message", message));
    }

    @Override
    public void onResume() {
        super.onResume();
        loadeHeaderData();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}