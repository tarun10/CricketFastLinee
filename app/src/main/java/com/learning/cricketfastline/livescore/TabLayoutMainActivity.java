package com.learning.cricketfastline.livescore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.livescore.fragment.FragmentAdapter;
import com.learning.cricketfastline.utility.CricketFastLine;

import io.socket.client.Socket;

public class TabLayoutMainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    private String[] tabHeading = {"Info", "LIVE", "ODDS", "SCORECARD", "STATISTICS"};
    private Toolbar toolbar;
    private Socket mSocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);
        CricketFastLine app = (CricketFastLine) TabLayoutMainActivity.this.getApplication();
        mSocket = app.getmSocket();
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);



        setSupportActionBar(toolbar);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        //toolbar.setTitle(getIntent().getStringExtra("title"));
        fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        viewPager2.setCurrentItem(1, true);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabHeading[position])).attach();

        toolbar.setNavigationOnClickListener(v -> finish());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mSocket.disconnect();
        mSocket.close();
    }
}