package com.learning.cricketfastline.utility;

import android.app.Application;
import android.widget.Toast;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class CricketFastLine extends Application {
    public static Socket mSocket = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mSocket == null) {
            try {
                mSocket = IO.socket("http://node.cricnet.co.in:7001");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    public static Socket getmSocket() {
        return mSocket;
    }
}
