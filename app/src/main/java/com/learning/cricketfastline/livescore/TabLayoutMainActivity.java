package com.learning.cricketfastline.livescore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.fragment.FragmentAdapter;
import com.learning.cricketfastline.livescore.fragment.InfoFragment;
import com.learning.cricketfastline.livescore.fragment.LiveScoreFragment;
import com.learning.cricketfastline.livescore.fragment.OddsFragment;
import com.learning.cricketfastline.livescore.fragment.ScorecardFragment;
import com.learning.cricketfastline.livescore.fragment.SeatsFragment;
import com.learning.cricketfastline.utility.CricketFastLine;
import com.learning.cricketfastline.utility.constantfiles.ConstantLinks;

import java.util.ArrayList;

import io.socket.client.Socket;

public class TabLayoutMainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    //private String[] tabHeading; {"Info", "LIVE", "ODDS", "SCORECARD", "STATISTICS"};
    private Toolbar toolbar;
    private Socket mSocket;
    ArrayList<Fragment> fragments=new ArrayList<>();
    ImageView adsframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);
        CricketFastLine app = (CricketFastLine) TabLayoutMainActivity.this.getApplication();
        mSocket = app.getmSocket();
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        adsframe = findViewById(R.id.adsframe);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        //toolbar.setTitle(getIntent().getStringExtra("title"));
        fragmentAdapter = new FragmentAdapter(this,getFragments("finished".equals(getIntent().getStringExtra("matchType"))?true:false));
        viewPager2.setAdapter(fragmentAdapter);
        viewPager2.setCurrentItem(1, true);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(getTabHeading("finished".equals(getIntent().getStringExtra("matchType"))?true:false)[position])).attach();

        toolbar.setNavigationOnClickListener(v -> finish());

        try {
            Glide.
                    with(getApplicationContext()).
                    load(ConstantLinks.BANNER_IMAGE_URL)
                    .into(adsframe);

        }catch (Exception e){

        }

        adsframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ConstantLinks.getWHATSAPPLINK()));
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mSocket.disconnect();
        mSocket.close();
    }
    public ArrayList<Fragment> getFragments(boolean ishistory)
    {
        if(!ishistory) {
            fragments.add(InfoFragment.getInstance());
            fragments.add(LiveScoreFragment.getInstance());
        }
        fragments.add(OddsFragment.getInstance());
        fragments.add(ScorecardFragment.getInstance());
        fragments.add(SeatsFragment.getInstance());

        return fragments;
    }
    public String[] getTabHeading(boolean ishistory)
    {
        String tabHeading[];
        if(!ishistory)
         tabHeading = new String[]{"Info", "LIVE", "ODDS", "SCORECARD", "STATISTICS"};
        else
            tabHeading = new String[]{"ODDS", "SCORECARD", "STATISTICS"};
        return tabHeading;
    }

}