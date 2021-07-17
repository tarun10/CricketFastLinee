package com.learning.cricketfastline.livescore.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.UpcomingDataModel;
import com.learning.cricketfastline.model.players.AllPlayersInfo;
import com.learning.cricketfastline.model.players.Players;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.observers.DisposableObserver;

public class ScoreCardViewModel extends ViewModel {

    MutableLiveData<ArrayList<Players>> mutableLiveData = new MutableLiveData<>();
    LiveData<ArrayList<UpcomingDataModel>> arrayListLiveData = null;

    public ScoreCardViewModel() {

    }

    public MutableLiveData<ArrayList<Players>> getUpComingData(HashMap<String, String> scoreInfo) {
        ApiServices.getPlayesrInfo(scoreInfo).subscribeWith(new DisposableObserver<AllPlayersInfo>() {
            @Override
            public void onNext(AllPlayersInfo jsonObject) {
                if (jsonObject != null) {
                    mutableLiveData.setValue(jsonObject.getPlayerslist());
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
