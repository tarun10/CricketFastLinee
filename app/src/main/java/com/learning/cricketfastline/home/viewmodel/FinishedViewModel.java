package com.learning.cricketfastline.home.viewmodel;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.AllMatch;
import com.learning.cricketfastline.model.MatchPojo;
import com.learning.cricketfastline.model.MatchWithTitle;
import com.learning.cricketfastline.model.UpcomingDataModel;
import com.learning.cricketfastline.remoteconnection.RetrofitConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinishedViewModel extends ViewModel {
    MutableLiveData<ArrayList<MatchWithTitle>> mutableLiveData = new MutableLiveData<>();
    LiveData<ArrayList<UpcomingDataModel>> arrayListLiveData = null;

    public FinishedViewModel() {

    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getFinishedData() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("start", "1");
        stringHashMap.put("end", "15");
        Call<MatchPojo> upcomingDataModelCall = RetrofitConnection.callApi().getFinishedData(stringHashMap);
        upcomingDataModelCall.enqueue(new Callback<MatchPojo>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<MatchPojo> call, Response<MatchPojo> response) {

                if (response.isSuccessful()) {
                    String previousDate = null;
                    ArrayList<MatchWithTitle> matchWithTitles = new ArrayList<>();
                    LinkedHashMap<String, Object> stringObjectHashMap = new LinkedHashMap<>();
                    ArrayList<AllMatch> allMatches = new ArrayList<>();
                    for (int i = 0; i < response.body().getAllMatch().size(); i++) {
                        AllMatch allMatch = response.body().getAllMatch().get(i);

                        if (allMatch.getMatchtime() != null) {
                            String matchdate;
                            if (allMatch.getTitle().contains("Test")) {
                                matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().lastIndexOf(",") - 1);
                            } else {
                                matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().indexOf("at") - 1);
                            }
                            if (stringObjectHashMap.containsKey(matchdate)) {
                                allMatches.add(allMatch);
                                stringObjectHashMap.put(matchdate, allMatches);
                            } else {
                                previousDate = matchdate;
                                allMatches = new ArrayList<>();
                                allMatches.add(allMatch);
                                stringObjectHashMap.put(previousDate, allMatches);
                            }
                        }

                    }

                    for (Map.Entry<String, Object> entry : stringObjectHashMap.entrySet()) {
                        System.out.println(entry.getKey() + " => " + ": " + entry.getValue());
                        matchWithTitles.add(new MatchWithTitle(entry.getKey(), (ArrayList<AllMatch>) entry.getValue()));
                        Log.d("data", String.valueOf(matchWithTitles));
                    }
                    mutableLiveData.setValue(matchWithTitles);

                }
            }

            @Override
            public void onFailure(Call<MatchPojo> call, Throwable t) {
                Log.d("errorData", t.toString());
            }
        });
        return mutableLiveData;
    }
}