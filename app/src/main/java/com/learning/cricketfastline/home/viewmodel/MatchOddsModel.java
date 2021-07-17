package com.learning.cricketfastline.home.viewmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MatchOddsModel {

    @SerializedName("Matchst")
    @Expose
    private ArrayList<Matchst> matchst = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;

    public ArrayList<Matchst> getMatchst() {
        return matchst;
    }

    public void setMatchst(ArrayList<Matchst> matchst) {
        this.matchst = matchst;
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
