package com.learning.cricketfastline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocketLiveScore {
    @SerializedName("batsman")
    @Expose
    private String batsman;
    @SerializedName("s4")
    @Expose
    private String s4;
    @SerializedName("s6")
    @Expose
    private String s6;
    @SerializedName("ns4")
    @Expose
    private String ns4;
    @SerializedName("ns6")
    @Expose
    private String ns6;
    @SerializedName("bowler")
    @Expose
    private String bowler;
    @SerializedName("oversA")
    @Expose
    private String oversA;
    @SerializedName("oversB")
    @Expose
    private String oversB;
    @SerializedName("rateA")
    @Expose
    private String rateA;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("sessionA")
    @Expose
    private String sessionA;
    @SerializedName("sessionB")
    @Expose
    private String sessionB;
    @SerializedName("sessionOver")
    @Expose
    private String sessionOver;
    @SerializedName("teamA")
    @Expose
    private String teamA;
    @SerializedName("teamB")
    @Expose
    private String teamB;
    @SerializedName("totalballs")
    @Expose
    private String totalballs;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("wicketA")
    @Expose
    private String wicketA;
    @SerializedName("wicketB")
    @Expose
    private String wicketB;
    @SerializedName("Last6Balls")
    @Expose
    private String last6Balls;
    @SerializedName("TeamABanner")
    @Expose
    private String teamABanner;
    @SerializedName("TeamBBanner")
    @Expose
    private String teamBBanner;
    @SerializedName("imgurl")
    @Expose
    private String imgurl;
    @SerializedName("matchtype")
    @Expose
    private String matchtype;
    @SerializedName("TestTeamA")
    @Expose
    private String testTeamA;
    @SerializedName("TestTeamARate1")
    @Expose
    private String testTeamARate1;
    @SerializedName("TestTeamARate2")
    @Expose
    private String testTeamARate2;
    @SerializedName("TestTeamB")
    @Expose
    private String testTeamB;
    @SerializedName("TestTeamBRate1")
    @Expose
    private String testTeamBRate1;
    @SerializedName("TestTeamBRate2")
    @Expose
    private String testTeamBRate2;
    @SerializedName("Testdraw")
    @Expose
    private String testdraw;
    @SerializedName("TestdrawRate1")
    @Expose
    private String testdrawRate1;
    @SerializedName("TestdrawRate2")
    @Expose
    private String testdrawRate2;
    @SerializedName("MatchId")
    @Expose
    private Integer matchId;
    @SerializedName("runxa")
    @Expose
    private Integer runxa;
    @SerializedName("runxb")
    @Expose
    private Integer runxb;
    @SerializedName("fav")
    @Expose
    private String fav;
    @SerializedName("rateB")
    @Expose
    private String rateB;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("stat")
    @Expose
    private String stat;

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public String getS6() {
        return s6;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }

    public String getNs4() {
        return ns4;
    }

    public void setNs4(String ns4) {
        this.ns4 = ns4;
    }

    public String getNs6() {
        return ns6;
    }

    public void setNs6(String ns6) {
        this.ns6 = ns6;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getOversA() {
        return oversA;
    }

    public void setOversA(String oversA) {
        this.oversA = oversA;
    }

    public String getOversB() {
        return oversB;
    }

    public void setOversB(String oversB) {
        this.oversB = oversB;
    }

    public String getRateA() {
        return rateA;
    }

    public void setRateA(String rateA) {
        this.rateA = rateA;
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

    public String getSessionOver() {
        return sessionOver;
    }

    public void setSessionOver(String sessionOver) {
        this.sessionOver = sessionOver;
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

    public String getTotalballs() {
        return totalballs;
    }

    public void setTotalballs(String totalballs) {
        this.totalballs = totalballs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLast6Balls() {
        return last6Balls;
    }

    public void setLast6Balls(String last6Balls) {
        this.last6Balls = last6Balls;
    }

    public String getTeamABanner() {
        return teamABanner;
    }

    public void setTeamABanner(String teamABanner) {
        this.teamABanner = teamABanner;
    }

    public String getTeamBBanner() {
        return teamBBanner;
    }

    public void setTeamBBanner(String teamBBanner) {
        this.teamBBanner = teamBBanner;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(String matchtype) {
        this.matchtype = matchtype;
    }

    public String getTestTeamA() {
        return testTeamA;
    }

    public void setTestTeamA(String testTeamA) {
        this.testTeamA = testTeamA;
    }

    public String getTestTeamARate1() {
        return testTeamARate1;
    }

    public void setTestTeamARate1(String testTeamARate1) {
        this.testTeamARate1 = testTeamARate1;
    }

    public String getTestTeamARate2() {
        return testTeamARate2;
    }

    public void setTestTeamARate2(String testTeamARate2) {
        this.testTeamARate2 = testTeamARate2;
    }

    public String getTestTeamB() {
        return testTeamB;
    }

    public void setTestTeamB(String testTeamB) {
        this.testTeamB = testTeamB;
    }

    public String getTestTeamBRate1() {
        return testTeamBRate1;
    }

    public void setTestTeamBRate1(String testTeamBRate1) {
        this.testTeamBRate1 = testTeamBRate1;
    }

    public String getTestTeamBRate2() {
        return testTeamBRate2;
    }

    public void setTestTeamBRate2(String testTeamBRate2) {
        this.testTeamBRate2 = testTeamBRate2;
    }

    public String getTestdraw() {
        return testdraw;
    }

    public void setTestdraw(String testdraw) {
        this.testdraw = testdraw;
    }

    public String getTestdrawRate1() {
        return testdrawRate1;
    }

    public void setTestdrawRate1(String testdrawRate1) {
        this.testdrawRate1 = testdrawRate1;
    }

    public String getTestdrawRate2() {
        return testdrawRate2;
    }

    public void setTestdrawRate2(String testdrawRate2) {
        this.testdrawRate2 = testdrawRate2;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getRunxa() {
        return runxa;
    }

    public void setRunxa(Integer runxa) {
        this.runxa = runxa;
    }

    public Integer getRunxb() {
        return runxb;
    }

    public void setRunxb(Integer runxb) {
        this.runxb = runxb;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getRateB() {
        return rateB;
    }

    public void setRateB(String rateB) {
        this.rateB = rateB;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
