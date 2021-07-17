package com.learning.cricketfastline.model.players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Players {
    @SerializedName("TeamName")
    @Expose
    private String teamName;
    @SerializedName("PlayerName")
    @Expose
    private String playerName;
    @SerializedName("MatchId")
    @Expose
    private Integer matchId;
    @SerializedName("TeamRuns")
    @Expose
    private String teamRuns;
    @SerializedName("PlayerImage")
    @Expose
    private String playerImage;
    @SerializedName("Runs")
    @Expose
    private Integer runs;
    @SerializedName("TeamSide")
    @Expose
    private String teamSide;
    @SerializedName("Balls")
    @Expose
    private Integer balls;
    @SerializedName("four")
    @Expose
    private Integer four;
    @SerializedName("six")
    @Expose
    private Integer six;
    @SerializedName("seqno")
    @Expose
    private Integer seqno;
    @SerializedName("outby")
    @Expose
    private String outby;
    @SerializedName("inning")
    @Expose
    private Integer inning;
    @SerializedName("isnotout")
    @Expose
    private Integer isnotout;
    @SerializedName("matchtype")
    @Expose
    private String matchtype;


    @SerializedName("TestTeamA")
    @Expose
    private String TestTeamA;
    @SerializedName("TestTeamARate1")
    @Expose
    private String TestTeamARate1;

    @SerializedName("TestTeamARate2")
    @Expose
    private String TestTeamARate2;

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

    public String getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(String matchtype) {
        this.matchtype = matchtype;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getTeamRuns() {
        return teamRuns;
    }

    public void setTeamRuns(String teamRuns) {
        this.teamRuns = teamRuns;
    }

    public String getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(String playerImage) {
        this.playerImage = playerImage;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getTeamSide() {
        return teamSide;
    }

    public void setTeamSide(String teamSide) {
        this.teamSide = teamSide;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getFour() {
        return four;
    }

    public void setFour(Integer four) {
        this.four = four;
    }

    public Integer getSix() {
        return six;
    }

    public void setSix(Integer six) {
        this.six = six;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    public String getOutby() {
        return outby;
    }

    public void setOutby(String outby) {
        this.outby = outby;
    }

    public Integer getInning() {
        return inning;
    }

    public void setInning(Integer inning) {
        this.inning = inning;
    }

    public Integer getIsnotout() {
        return isnotout;
    }

    public void setIsnotout(Integer isnotout) {
        this.isnotout = isnotout;
    }
}
