package com.learning.cricketfastline.pointtable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricketfastline.model.seriesdata.PointTableModel;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import java.util.HashMap;

import io.reactivex.observers.DisposableObserver;

public class PintTableViewModel extends ViewModel {

    MutableLiveData<PointTableModel> mutableLiveData = new MutableLiveData<>();

    public PintTableViewModel() {
        super();
    }

    public MutableLiveData<PointTableModel> getPontTable(HashMap<String, String> pointinfo) {

        ApiServices.getPointTable(pointinfo).subscribeWith(new DisposableObserver<PointTableModel>() {
            @Override
            public void onNext(PointTableModel liveSeries) {
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