package com.learning.cricketfastline.model.seriesdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pointsst {
    @SerializedName("SeriesId")
    @Expose
    private Integer seriesId;
    @SerializedName("TeamName")
    @Expose
    private String teamName;
    @SerializedName("TeamImage")
    @Expose
    private String teamImage;
    @SerializedName("Url")
    @Expose
    private String url;
    @SerializedName("Matches")
    @Expose
    private Integer matches;
    @SerializedName("Won")
    @Expose
    private Integer won;
    @SerializedName("Lost")
    @Expose
    private Integer lost;
    @SerializedName("Tied")
    @Expose
    private Integer tied;
    @SerializedName("NR")
    @Expose
    private Integer nr;
    @SerializedName("Pts")
    @Expose
    private Integer pts;
    @SerializedName("NRR")
    @Expose
    private String nrr;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(String teamImage) {
        this.teamImage = teamImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getTied() {
        return tied;
    }

    public void setTied(Integer tied) {
        this.tied = tied;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public Integer getPts() {
        return pts;
    }

    public void setPts(Integer pts) {
        this.pts = pts;
    }

    public String getNrr() {
        return nrr;
    }

    public void setNrr(String nrr) {
        this.nrr = nrr;
    }
}
