package com.learning.cricketfastline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllMatch {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Matchtime")
    @Expose
    private String matchtime;
    @SerializedName("Venue")
    @Expose
    private String venue;
    @SerializedName("MatchId")
    @Expose
    private Integer matchId;
    @SerializedName("TeamA")
    @Expose
    private String teamA;
    @SerializedName("TeamB")
    @Expose
    private String teamB;
    @SerializedName("TeamAImage")
    @Expose
    private String teamAImage;
    @SerializedName("Matchtype")
    @Expose
    private String matchtype;
    @SerializedName("TeamBImage")
    @Expose
    private String teamBImage;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getTeamAImage() {
        return teamAImage;
    }

    public void setTeamAImage(String teamAImage) {
        this.teamAImage = teamAImage;
    }

    public String getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(String matchtype) {
        this.matchtype = matchtype;
    }

    public String getTeamBImage() {
        return teamBImage;
    }

    public void setTeamBImage(String teamBImage) {
        this.teamBImage = teamBImage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
