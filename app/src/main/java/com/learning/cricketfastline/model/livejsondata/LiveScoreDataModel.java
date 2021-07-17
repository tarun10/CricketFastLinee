package com.learning.cricketfastline.model.livejsondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveScoreDataModel {

    @SerializedName("jsondata")
    @Expose
    private Jsondata jsondata;

    public Jsondata getJsondata() {
        return jsondata;
    }

    public void setJsondata(Jsondata jsondata) {
        this.jsondata = jsondata;
    }
}
