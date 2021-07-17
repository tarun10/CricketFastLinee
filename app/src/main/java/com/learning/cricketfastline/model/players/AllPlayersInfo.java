package com.learning.cricketfastline.model.players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllPlayersInfo {
    @SerializedName("Playerslist")
    @Expose
    private ArrayList<Players> playerslist = null;
    @SerializedName("AllMatch")
    @Expose
    private Object allMatch;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;

    public ArrayList<Players> getPlayerslist() {
        return playerslist;
    }

    public void setPlayerslist(ArrayList<Players> playerslist) {
        this.playerslist = playerslist;
    }

    public Object getAllMatch() {
        return allMatch;
    }

    public void setAllMatch(Object allMatch) {
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
