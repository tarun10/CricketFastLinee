 package com.learning.cricketfastline;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.view.MenuItem;
 import android.view.View;
 import android.widget.ImageView;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.fragment.app.Fragment;
 import androidx.navigation.NavController;

 import com.google.android.material.bottomnavigation.BottomNavigationView;
 import com.learning.cricketfastline.utility.constantfiles.ConstantLinks;

 public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;
    Toolbar toolbar;
    private ImageView adsframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {

        adsframe = findViewById(R.id.adsframe);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HomeFragment()).commit();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        adsframe.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.WHATSAPPLINK));
            startActivity(i);
        });
    }



    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seletctedFragment = null;
            switch (item.getItemId()){
                case R.id.homeFragment:
                    seletctedFragment = new HomeFragment();
                    break;
                case R.id.newsFragment:
                    seletctedFragment = new NewsFragment();
                    break;
                case R.id.fixturesFragment:
                    seletctedFragment = new FixturesFragment();
                    break;
                case R.id.settingsFragment:
                    seletctedFragment = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer,seletctedFragment).commit();
            return true;
        }
    };
}