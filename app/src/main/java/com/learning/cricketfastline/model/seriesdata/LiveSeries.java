package com.learning.cricketfastline.model.seriesdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveSeries {
    @SerializedName("seriesname")
    @Expose
    private String seriesname;
    @SerializedName("seriesid")
    @Expose
    private Integer seriesid;
    @SerializedName("startdate")
    @Expose
    private String startdate;
    @SerializedName("enddate")
    @Expose
    private String enddate;

    public String getSeriesname() {
        return seriesname;
    }

    public void setSeriesname(String seriesname) {
        this.seriesname = seriesname;
    }

    public Integer getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {
        this.seriesid = seriesid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
