package com.learning.cricketfastline.FixtureFragment.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cricket.adfreecricketliveline.model.AllMatch;
import com.cricket.adfreecricketliveline.model.MatchPojo;
import com.cricket.adfreecricketliveline.model.MatchWithTitle;
import com.cricket.adfreecricketliveline.model.UpcomingDataModel;
import com.cricket.adfreecricketliveline.remoteconnection.ApiServices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class SeriesViewModel extends ViewModel {
    MutableLiveData<ArrayList<MatchWithTitle>> mutableLiveData = new MutableLiveData<>();
    LiveData<ArrayList<UpcomingDataModel>> arrayListLiveData = null;

    public SeriesViewModel() {

    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getAllFixture() {

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
                        if (!allMatch.getTitle().contains("Test")) {
                            String matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().indexOf("at") - 1);
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getTestFixture() {

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
                        if (allMatch.getTitle().contains("Test")) {
                            String matchdate = allMatch.getMatchtime();//.substring(0, allMatch.getMatchtime().indexOf("at") - 1);
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getAllT20() {
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
                        if (!allMatch.getTitle().contains("Test") && allMatch.getTitle().contains("T20")) {
                            String matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().indexOf("at") - 1);
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getAllT10() {
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
                        if (!allMatch.getTitle().contains("Test") && allMatch.getTitle().contains("T10")) {
                            String matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().indexOf("at") - 1);
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ArrayList<MatchWithTitle>> getAllODI() {
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
                        if (!allMatch.getTitle().contains("Test") && allMatch.getTitle().contains("ODI")) {
                            String matchdate = allMatch.getMatchtime().substring(0, allMatch.getMatchtime().indexOf("at") - 1);
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
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }
}