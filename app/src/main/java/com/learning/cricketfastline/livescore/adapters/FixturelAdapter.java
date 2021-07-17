package com.learning.cricketfastline.livescore.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.learning.cricketfastline.FixtureFragment.AllFixtureFragment;
import com.learning.cricketfastline.FixtureFragment.OdiFixtureFragment;
import com.learning.cricketfastline.FixtureFragment.T10FixtureFragment;
import com.learning.cricketfastline.FixtureFragment.T20FixtureFragment;
import com.learning.cricketfastline.FixtureFragment.TestFixtureFragment;

public class FixturelAdapter extends FragmentStateAdapter {

    public FixturelAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllFixtureFragment();
            case 1:
                return new OdiFixtureFragment();
            case 2:
                return new T20FixtureFragment();
            case 3:
                return new T10FixtureFragment();
            case 4:
                return new TestFixtureFragment();

            /*  case 5:
                return new InternationalFixtureFragment();

          case 6:
                return new WomenFixtureFragment();
            case 7:
                return new LeagueFixtureFragment();*/
            default:
                return new AllFixtureFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
