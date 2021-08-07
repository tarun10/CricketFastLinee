package com.learning.cricketfastline.model.stats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchStats {
    @SerializedName("Matchst")
    @Expose
    private List<Matchst> matchst = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;

    public List<Matchst> getMatchst() {
        return matchst;
    }

    public void setMatchst(List<Matchst> matchst) {
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
