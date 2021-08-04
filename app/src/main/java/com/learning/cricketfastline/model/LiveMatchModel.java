package com.learning.cricketfastline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveMatchModel {
    @SerializedName("jsonruns")
    @Expose
    private String jsonruns;
    @SerializedName("jsondata")
    @Expose
    private String jsondata;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Matchtime")
    @Expose
    private String matchtime;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("isfinished")
    @Expose
    private Integer isfinished;
    @SerializedName("ispriority")
    @Expose
    private Integer ispriority;
    @SerializedName("TeamA")
    @Expose
    private String teamA;
    @SerializedName("TeamAImage")
    @Expose
    private String teamAImage;
    @SerializedName("TeamB")
    @Expose
    private String teamB;
    @SerializedName("seriesid")
    @Expose
    private Integer seriesid;
    @SerializedName("TeamBImage")
    @Expose
    private String teamBImage;
    @SerializedName("ImgeURL")
    @Expose
    private String imgeURL;
    @SerializedName("MatchType")
    @Expose
    private String matchType;
    @SerializedName("MatchDate")
    @Expose
    private String matchDate;
    @SerializedName("MatchId")
    @Expose
    private Integer matchId;
    @SerializedName("Appversion")
    @Expose
    private String appversion;
    @SerializedName("adphone")
    @Expose
    private String adphone;
    @SerializedName("adimage")
    @Expose
    private String adimage;
    @SerializedName("admsg")
    @Expose
    private String admsg;
    @SerializedName("wicketA")
    @Expose
    private String wicketA;
    @SerializedName("wicketB")
    @Expose
    private String wicketB;

    @SerializedName("TestTeamA")
    @Expose
    private String TestTeamA;
    @SerializedName("TestTeamARate1")
    @Expose
    private String TestTeamARate1;

    @SerializedName("TestTeamARate2")
    @Expose
    private String TestTeamARate2;

    public LiveMatchModel(String title, String imgeURL) {
        this.title=title;
        this.imgeURL=imgeURL;
    }

    public String getTestTeamA() {
        return TestTeamA;
    }

    public void setTestTeamA(String testTeamA) {
        TestTeamA = testTeamA;
    }

    public String getTestTeamARate1() {
        return TestTeamARate1;
    }

    public void setTestTeamARate1(String testTeamARate1) {
        TestTeamARate1 = testTeamARate1;
    }

    public String getTestTeamARate2() {
        return TestTeamARate2;
    }

    public void setTestTeamARate2(String testTeamARate2) {
        TestTeamARate2 = testTeamARate2;
    }

    public String getWicketA() {
        return wicketA;
    }

    public void setWicketA(String wicketA) {
        this.wicketA = wicketA;
    }

    public String getWicketB() {
        return wicketB;
    }

    public void setWicketB(String wicketB) {
        this.wicketB = wicketB;
    }

    public String getJsonruns() {
        return jsonruns;
    }

    public void setJsonruns(String jsonruns) {
        this.jsonruns = jsonruns;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getIsfinished() {
        return isfinished;
    }

    public void setIsfinished(Integer isfinished) {
        this.isfinished = isfinished;
    }

    public Integer getIspriority() {
        return ispriority;
    }

    public void setIspriority(Integer ispriority) {
        this.ispriority = ispriority;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamAImage() {
        return teamAImage;
    }

    public void setTeamAImage(String teamAImage) {
        this.teamAImage = teamAImage;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {
        this.seriesid = seriesid;
    }

    public String getTeamBImage() {
        return teamBImage;
    }

    public void setTeamBImage(String teamBImage) {
        this.teamBImage = teamBImage;
    }

    public String getImgeURL() {
        return imgeURL;
    }

    public void setImgeURL(String imgeURL) {
        this.imgeURL = imgeURL;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getAdphone() {
        return adphone;
    }

    public void setAdphone(String adphone) {
        this.adphone = adphone;
    }

    public String getAdimage() {
        return adimage;
    }

    public void setAdimage(String adimage) {
        this.adimage = adimage;
    }

    public String getAdmsg() {
        return admsg;
    }

    public void setAdmsg(String admsg) {
        this.admsg = admsg;
    }
}
