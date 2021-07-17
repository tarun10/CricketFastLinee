package com.learning.cricketfastline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.livescore.adapters.FixturelAdapter;

public class FixturesFragment extends Fragment {

    private TabLayout fixtureTabLayout;
    private ViewPager2 fixtureViewPager;
    private FixturelAdapter fixturelAdapter;
    private String[] tabHeading = {"ALL", "ODI", "T20", "T10", "TEST" /*,"INTERNATIONAL","WOMEN", "LEAGUE"*/};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        fixtureTabLayout = view.findViewById(R.id.fixtureTabLayout);
        fixtureViewPager = view.findViewById(R.id.fixtureViewPager);
        fixtureViewPager.setOffscreenPageLimit(7);
        fixturelAdapter = new FixturelAdapter(getActivity());
        fixtureViewPager.setAdapter(fixturelAdapter);

        new TabLayoutMediator(fixtureTabLayout, fixtureViewPager,
                (tab, position) -> tab.setText(tabHeading[position])).attach();
        return view;
    }
}