package com.learning.cricketfastline.viewpageradapters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

public class HomeFragementViewModel extends ViewModel {

    MutableLiveData<ArrayList<LiveMatchModel>> mutableLiveData = new MutableLiveData<>();
    public HomeFragementViewModel() {

    }
    public MutableLiveData<ArrayList<LiveMatchModel>> getUpComingData() {
        ApiServices.getHomeScreenLiveData().subscribeWith(new DisposableObserver<ArrayList<LiveMatchModel>>() {
            @Override
            public void onNext(ArrayList<LiveMatchModel> jsonObject) {
                if (jsonObject != null) {
                    mutableLiveData.setValue(jsonObject);
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
