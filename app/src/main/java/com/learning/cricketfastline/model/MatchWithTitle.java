package com.learning.cricketfastline.model;

import java.util.ArrayList;

public class MatchWithTitle {
    String title;
    ArrayList<AllMatch> allMatches;

    public MatchWithTitle(String title, ArrayList<AllMatch> allMatches) {
        this.title = title;
        this.allMatches = allMatches;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<AllMatch> getAllMatches() {
        return allMatches;
    }

    public void setAllMatches(ArrayList<AllMatch> allMatches) {
        this.allMatches = allMatches;
    }
}
