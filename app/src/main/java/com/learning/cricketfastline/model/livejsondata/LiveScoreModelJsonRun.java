package com.learning.cricketfastline.model.livejsondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveScoreModelJsonRun {
    @SerializedName("jsonruns")
    @Expose
    private Jsonruns jsonruns;
    public Jsonruns getJsonruns() {
        return jsonruns;
    }
    public void setJsonruns(Jsonruns jsonruns) {
        this.jsonruns = jsonruns;
    }
}
