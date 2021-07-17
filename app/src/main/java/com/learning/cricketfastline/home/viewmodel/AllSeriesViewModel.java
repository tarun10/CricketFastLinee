package com.learning.cricketfastline.home.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.seriesdata.LiveSeries;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

public class AllSeriesViewModel extends ViewModel {

    MutableLiveData<ArrayList<LiveSeries>> mutableLiveData = new MutableLiveData<>();

    public AllSeriesViewModel() {
        super();
    }

    public MutableLiveData<ArrayList<LiveSeries>> getAllSeriesData() {

        ApiServices.getAllSeries().subscribeWith(new DisposableObserver<ArrayList<LiveSeries>>() {
            @Override
            public void onNext(ArrayList<LiveSeries> liveSeries) {
                if (liveSeries != null) {
                    mutableLiveData.setValue(liveSeries);
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