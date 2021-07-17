package com.learning.cricketfastline.utility;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.learning.cricketfastline.R;


public class CommonFunction {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static DividerItemDecoration itemDecoration(Context context) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
//        dividerItemDecoration.setDrawable(context.getDrawable(R.drawable.horizental_line));
        dividerItemDecoration.setDrawable(context.getDrawable(R.drawable.horizental_line));
        return dividerItemDecoration;
    }
}
