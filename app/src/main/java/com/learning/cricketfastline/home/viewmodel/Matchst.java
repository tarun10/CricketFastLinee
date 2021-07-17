package com.learning.cricketfastline.home.viewmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Matchst {

    @SerializedName("Teamruns")
    @Expose
    private String teamruns;
    @SerializedName("Score")
    @Expose
    private String score;
    @SerializedName("SessionA")
    @Expose
    private String sessionA;
    @SerializedName("SessionB")
    @Expose
    private String sessionB;
    @SerializedName("overs")
    @Expose
    private String overs;
    @SerializedName("MatchId")
    @Expose
    private Integer matchId;
    @SerializedName("Battingteam")
    @Expose
    private String battingteam;
    @SerializedName("wickets")
    @Expose
    private String wickets;
    @SerializedName("MrateA")
    @Expose
    private String mrateA;
    @SerializedName("MrateB")
    @Expose
    private String mrateB;
    @SerializedName("favourite")
    @Expose
    private String favourite;
    @SerializedName("isfirstinning")
    @Expose
    private String isfirstinning;
    @SerializedName("subdate")
    @Expose
    private String subdate;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getTeamruns() {
        return teamruns;
    }

    public void setTeamruns(String teamruns) {
        this.teamruns = teamruns;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSessionA() {
        return sessionA;
    }

    public void setSessionA(String sessionA) {
        this.sessionA = sessionA;
    }

    public String getSessionB() {
        return sessionB;
    }

    public void setSessionB(String sessionB) {
        this.sessionB = sessionB;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getBattingteam() {
        return battingteam;
    }

    public void setBattingteam(String battingteam) {
        this.battingteam = battingteam;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getMrateA() {
        return mrateA;
    }

    public void setMrateA(String mrateA) {
        this.mrateA = mrateA;
    }

    public String getMrateB() {
        return mrateB;
    }

    public void setMrateB(String mrateB) {
        this.mrateB = mrateB;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getIsfirstinning() {
        return isfirstinning;
    }

    public void setIsfirstinning(String isfirstinning) {
        this.isfirstinning = isfirstinning;
    }

    public String getSubdate() {
        return subdate;
    }

    public void setSubdate(String subdate) {
        this.subdate = subdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}


