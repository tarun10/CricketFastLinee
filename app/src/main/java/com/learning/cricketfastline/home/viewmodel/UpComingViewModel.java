package com.learning.cricketfastline.home.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.learning.cricketfastline.model.AllMatch;
import com.learning.cricketfastline.model.MatchPojo;
import com.learning.cricketfastline.model.MatchWithTitle;
import com.learning.cricketfastline.model.UpcomingDataModel;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class UpComingViewModel extends ViewModel {
    MutableLiveData<ArrayList<MatchWithTitle>> mutableLiveData = new MutableLiveData<>();
    LiveData<ArrayList<UpcomingDataModel>> arrayListLiveData = null;

    public UpComingViewModel() {

    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getUpComingData() {
        ApiServices.getAllFixture().subscribeWith(new DisposableObserver<MatchPojo>() {
            @Override
            public void onNext(MatchPojo matchPojo) {
                if (matchPojo != null) {
                    String previousDate = null;
                    ArrayList<MatchWithTitle> matchWithTitles = new ArrayList<>();
                    LinkedHashMap<String, Object> stringObjectHashMap = new LinkedHashMap<>();
                    ArrayList<AllMatch> allMatches = new ArrayList<>();
                    for (int i = 0; i < matchPojo.getAllMatch().size(); i++) {
                        AllMatch allMatch = matchPojo.getAllMatch().get(i);
                        //if (!allMatch.getTitle().contains("Test")) {
                            String matchdate=null;
                            //Jun 10, Thu - Jun 14, Mon-03:30PM
                            if(allMatch.getTitle().contains("Test"))
                            {
                                matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().lastIndexOf(",") - 1);
                            }else {
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
                        //}
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }
}