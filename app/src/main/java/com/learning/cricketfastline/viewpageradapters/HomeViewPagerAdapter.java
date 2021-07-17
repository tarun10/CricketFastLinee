package com.learning.cricketfastline.viewpageradapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.learning.cricketfastline.home.AllSeriesFragment;
import com.learning.cricketfastline.home.FinishedFragment;
import com.learning.cricketfastline.home.LiveHomeFragment;
import com.learning.cricketfastline.home.UpcomingFragment;

public class HomeViewPagerAdapter extends FragmentStateAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new UpcomingFragment();
            case 2:
                return new FinishedFragment();
            case 3:
                return new AllSeriesFragment();
            default:
                return new LiveHomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
