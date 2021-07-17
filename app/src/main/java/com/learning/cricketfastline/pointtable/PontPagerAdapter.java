package com.learning.cricketfastline.pointtable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PontPagerAdapter extends FragmentStateAdapter {

    public PontPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 0:
                return new SeriesFixtureFragment();
            case 1:
                return new PointTableFragment();

            default:
                return new SeriesFixtureFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
