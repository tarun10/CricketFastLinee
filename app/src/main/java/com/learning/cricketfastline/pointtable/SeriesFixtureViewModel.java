package com.learning.cricketfastline.pointtable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.observers.DisposableObserver;

public class SeriesFixtureViewModel extends ViewModel {

    MutableLiveData<ArrayList<LiveMatchModel>> mutableLiveData = new MutableLiveData<>();

    public SeriesFixtureViewModel() {
        super();
    }

    public MutableLiveData<ArrayList<LiveMatchModel>> getAllSeriesData(HashMap<String, String> seriesinfo) {

        ApiServices.getSelectedSeries(seriesinfo).subscribeWith(new DisposableObserver<ArrayList<LiveMatchModel>>() {
            @Override
            public void onNext(ArrayList<LiveMatchModel> liveSeries) {
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