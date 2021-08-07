package com.learning.cricketfastline.remoteconnection;


import com.learning.cricketfastline.home.viewmodel.MatchOddsModel;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.model.MatchPojo;
import com.learning.cricketfastline.model.news.NewsModelApi;
import com.learning.cricketfastline.model.players.AllPlayersInfo;
import com.learning.cricketfastline.model.seriesdata.LiveSeries;
import com.learning.cricketfastline.model.seriesdata.PointTableModel;
import com.learning.cricketfastline.model.stats.MatchStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiServices {
    public static Observable<ArrayList<LiveMatchModel>> getLiveScore(HashMap<String, String> scoreInfo) {
        return RetrofitConnection.callApi().getMatchInfor(scoreInfo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<AllPlayersInfo> getPlayesrInfo(HashMap<String, String> scoreInfo) {
        return RetrofitConnection.callApi().GetAllPlayers(scoreInfo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MatchOddsModel> getMatchOddsInfo(HashMap<String, String> scoreInfo) {
        return RetrofitConnection.callApi().GetMatchOdds(scoreInfo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<ArrayList<LiveMatchModel>> getHomeScreenLiveData() {
        return RetrofitConnection.callApi().getLiveData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MatchPojo> getAllFixture() {
        return RetrofitConnection.callApi().upcomingData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<ArrayList<LiveSeries>> getAllSeries() {
        return RetrofitConnection.callApi().getAllSeries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<ArrayList<LiveMatchModel>> getSelectedSeries(HashMap<String, String> seriesinfo) {
        return RetrofitConnection.callApi().getSelectedSeries(seriesinfo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<PointTableModel> getPointTable(HashMap<String, String> seriesinfo) {
        return RetrofitConnection.callApi().getPontTable(seriesinfo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
    public static Observable<MatchStats> getMatchStats(HashMap<String, String> seriesinfo) {
        return RetrofitConnection.callApi().getMatchStats(seriesinfo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
    public static Observable<NewsModelApi> getAllNews() {
        //"country=in&category=sports&apiKey=5e338d60ae6544008dc09648a9b38c35"
        return RetrofitConnection.callNewsApi().getAllNews("in","sports","5e338d60ae6544008dc09648a9b38c35").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
}
