package com.learning.cricketfastline.livescore.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 0:
                return new InfoFragment();
            case 1:
                return new LiveScoreFragment();
            case 2:
                return new OddsFragment();
            case 3:
                return new ScorecardFragment();
            default:
                return new SeriesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
