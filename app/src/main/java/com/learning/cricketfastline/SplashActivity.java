package com.learning.cricketfastline;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.learning.cricketfastline.utility.constantfiles.ConstantLinks;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1500;

    String mLatestVersionName;
    VersionChecker versionChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        versionChecker = new VersionChecker();

        FirebaseMessaging.getInstance().subscribeToTopic("all");



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference phoneNumberRef = database.getReference("PhoneNumber");
        phoneNumberRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//              String s = (String) snapshot.getValue();
                Context context = getApplicationContext();
                PackageInfo pInfo = null;
                try {
                    String  phoneNumber = snapshot.getValue().toString();
                    ConstantLinks.setWHATSAPPLINK(phoneNumber);
                    Log.d("firebseNumbertarun",ConstantLinks.getWHATSAPPLINK());

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        appUpdatebyjsoup();

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
//                Log.d("hello","hellof");
//                startActivity(mainIntent);
//                finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);
    }


    public void appUpdatebyjsoup() {
        Context context = getApplicationContext();
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String currenVersion = pInfo.versionName;
            mLatestVersionName = versionChecker.execute().get();

            currenVersion = currenVersion.replaceAll("\\.","");
            mLatestVersionName = mLatestVersionName.replaceAll("\\.","");
            int one,two;
            one = Integer.parseInt(currenVersion);
            two = Integer.parseInt(mLatestVersionName);
            if (one < two) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setMessage("New version of Cricket Fast line is available please update....");
                builder.setTitle("New Udpate");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            Intent appStoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                            appStoreIntent.setPackage("com.android.vending");

                            startActivity(appStoreIntent);
                        } catch (android.content.ActivityNotFoundException exception) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                pbutton.setBackgroundColor(Color.GREEN);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
