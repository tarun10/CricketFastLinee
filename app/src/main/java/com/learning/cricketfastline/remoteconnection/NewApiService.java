package com.learning.cricketfastline.remoteconnection;

import com.learning.cricketfastline.model.news.NewsModelApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewApiService {
    @GET("top-headlines")
    Observable<NewsModelApi> getAllNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);
}
