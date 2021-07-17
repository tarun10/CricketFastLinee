package com.learning.cricketfastline.utility;

import android.icu.text.SimpleDateFormat;
import android.net.ParseException;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtility {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String getStartTime(String eventTime) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            final Date dateObj = sdf.parse(eventTime);
            String timeStamp = sdf.format(Calendar.getInstance().getTime()); //for current time
            Date date1 = sdf.parse(timeStamp);
            if (date1.getTime() > dateObj.getTime()) {
                return "null";
            } else {
                // Calculating the difference in milliseconds
                long differenceInMilliSeconds = Math.abs(date1.getTime() - dateObj.getTime());
                // Calculating the difference in Hours
                long nHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
                // Calculating the difference in Minutes
                long nMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
                String ahours = (String.valueOf(nHours).length() > 1 ? String.valueOf(nHours) : "0" + nHours);
                String aMinutes = (String.valueOf(nMinutes).length() > 1 ? String.valueOf(nMinutes) : "0" + nMinutes);
                return ahours + ":" + aMinutes;
            }


        } catch (final ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStrickRate(String run, String ball) {
        if (Integer.parseInt(ball) != 0) {
            double sr = (Double.parseDouble(run) / Double.parseDouble(ball));
            NumberFormat formatter = new DecimalFormat("##.00");
            double roundOff = Math.round(sr * 100.0) / 100.0;
            double value = roundOff * 100;
            return formatter.format(sr * 100);
        } else
            return "0";
    }
}
