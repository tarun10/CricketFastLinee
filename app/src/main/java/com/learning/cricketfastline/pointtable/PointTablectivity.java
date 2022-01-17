package com.learning.cricketfastline.pointtable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.utility.constantfiles.ConstantLinks;

public class PointTablectivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private PontPagerAdapter fragmentAdapter;
    private String[] tabHeading = {"Fixture", "Points"};
    private Toolbar toolbar;
    private ImageView adsframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_tablectivity);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        adsframe = findViewById(R.id.adsframe);

        setSupportActionBar(toolbar);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        toolbar.setTitle(getIntent().getStringExtra("title"));
        fragmentAdapter = new PontPagerAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        viewPager2.setOffscreenPageLimit(2);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabHeading[position])).attach();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        try {
            Glide.
                    with(getApplicationContext()).
                    load(ConstantLinks.BANNER_IMAGE_URL)
                    .into(adsframe);

        }catch (Exception e){

        }

        adsframe.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.getWHATSAPPLINK()));
            startActivity(i);
        });
    }
}