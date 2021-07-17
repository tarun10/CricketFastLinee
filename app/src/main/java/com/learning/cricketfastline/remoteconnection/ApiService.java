package com.learning.cricketfastline.remoteconnection;


import com.learning.cricketfastline.home.viewmodel.MatchOddsModel;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.model.MatchPojo;
import com.learning.cricketfastline.model.players.AllPlayersInfo;
import com.learning.cricketfastline.model.seriesdata.LiveSeries;
import com.learning.cricketfastline.model.seriesdata.PointTableModel;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("upcomingMatches")
    Observable<MatchPojo> upcomingData();

    @GET("LiveLine")
    Observable<ArrayList<LiveMatchModel>> getLiveData();

    @GET("LiveSeries")
    Observable<ArrayList<LiveSeries>> getAllSeries();

    @POST("MatchResults")
    Call<MatchPojo> getFinishedData(@Body HashMap<String, String> stringStringHashMap);

    @POST("LiveLine_Match")
    Observable<ArrayList<LiveMatchModel>> getMatchInfor(@Body HashMap<String, String> stringStringHashMap);

    @POST("GetAllPlayers")
    Observable<AllPlayersInfo> GetAllPlayers(@Body HashMap<String, String> stringStringHashMap);

    @POST("SeriesMatches")
    Observable<ArrayList<LiveMatchModel>> getSelectedSeries(@Body HashMap<String, String> stringStringHashMap);

    @POST("Pointstable")
    Observable<PointTableModel> getPontTable(@Body HashMap<String, String> stringStringHashMap);


    @POST("MatchOdds")
    Observable<MatchOddsModel> GetMatchOdds(@Body HashMap<String, String> stringStringHashMap);



}
