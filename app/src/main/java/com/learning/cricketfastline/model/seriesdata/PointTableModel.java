package com.learning.cricketfastline.model.seriesdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PointTableModel {
    @SerializedName("pointsst")
    @Expose
    private ArrayList<Pointsst> pointsst = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;

    public ArrayList<Pointsst> getPointsst() {
        return pointsst;
    }

    public void setPointsst(ArrayList<Pointsst> pointsst) {
        this.pointsst = pointsst;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
