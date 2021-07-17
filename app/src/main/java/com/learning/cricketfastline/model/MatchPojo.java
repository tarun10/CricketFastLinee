package com.learning.cricketfastline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MatchPojo {

    @SerializedName("Playerslist")
    @Expose
    private Object playerslist;
    @SerializedName("AllMatch")
    @Expose
    private ArrayList<AllMatch> allMatch = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;

    public Object getPlayerslist() {
        return playerslist;
    }

    public void setPlayerslist(Object playerslist) {
        this.playerslist = playerslist;
    }

    public ArrayList<AllMatch> getAllMatch() {
        return allMatch;
    }

    public void setAllMatch(ArrayList<AllMatch> allMatch) {
        this.allMatch = allMatch;
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
