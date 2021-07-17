package com.learning.cricketfastline.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Datetimeformat {


    public static String gettimehhmm(String time) {
        String tym = time;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date dateObj = sdf.parse(time);

            tym = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(dateObj);
            tym = tym.replace("a.m.", "am");
            tym = tym.replace("p.m.", "pm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tym;
    }

    public static String getdate1(String date) {
        String dt = date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date dateObj = sdf.parse(date);

            dt = new SimpleDateFormat("dd MMM ,yy", Locale.US).format(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }
    public static String getdate2(String date) {
        String dt = date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date dateObj = sdf.parse(date);

            dt = new SimpleDateFormat("dd MMM", Locale.US).format(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }
    public static String getdate3(String date) {
        String dt = date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date dateObj = sdf.parse(date);

            dt = new SimpleDateFormat("dd MMM yyyy", Locale.US).format(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static String gettime(String time) {

        String tym = time;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm", Locale.US);
            Date dateObj = sdf.parse(time);

            tym = new SimpleDateFormat("hh:mm a").format(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tym;
    }

}

