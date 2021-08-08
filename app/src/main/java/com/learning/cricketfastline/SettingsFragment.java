package com.learning.cricketfastline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;
import com.learning.cricketfastline.databinding.FragmentSettingsBinding;
import com.learning.cricketfastline.utility.constantfiles.ConstantLinks;

public class SettingsFragment extends Fragment {


    private FragmentSettingsBinding fragmentSettingsBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSettingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        View view = fragmentSettingsBinding.getRoot();
        fragmentSettingsBinding.facebooktextView.setOnClickListener(view13 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.FB));
            startActivity(i);
        });
        fragmentSettingsBinding.textView18.setOnClickListener(view12 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.INSTAGRAM));
            startActivity(i);
        });
        fragmentSettingsBinding.textView15.setOnClickListener(view1 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.WEBSITE));
            startActivity(i);
        });

        fragmentSettingsBinding.aboutUsView.setOnClickListener(view12 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.ABOUTUS));
            startActivity(i);
        });
        fragmentSettingsBinding.termsAndConditionUpdatetextView.setOnClickListener(view12 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.TERMS_CONDITIONS));
            startActivity(i);
        });
        fragmentSettingsBinding.privacyPolicyText.setOnClickListener(view12 -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.PRIVACY_POLICY));
            startActivity(i);
        });
        fragmentSettingsBinding.shareApp.setOnClickListener(view3 -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, ConstantLinks.SHARE);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

        });
        fragmentSettingsBinding.rateUsView.setOnClickListener(view1 -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(ConstantLinks.RATEUS)));
        });
        fragmentSettingsBinding.reportText15.setOnClickListener(view1 -> {
            try {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" +ConstantLinks.EMAIL ));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Report");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            } catch(Exception e) {
                Toast.makeText(getActivity(),"Sorry...You don't have any mail app", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
        return view;
    }

    public void addReview() {
        ReviewManager manager = ReviewManagerFactory.create(getActivity());
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                ReviewInfo reviewInfo = task.getResult();
                Task<Void> flow = manager.launchReviewFlow(getActivity(), reviewInfo);
                flow.addOnCompleteListener(task1 -> {
                    Log.d("mydata", "mydata");
                });

            } else {
                Log.d("mydata", "mydata");
            }
        });


    }
}