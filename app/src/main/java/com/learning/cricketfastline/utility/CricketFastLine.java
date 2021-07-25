package com.learning.cricketfastline.utility;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class CricketFastLine extends Application {
    public Socket mSocket;
    {
        try {
            IO.Options opts = new IO.Options();
            opts.reconnection = true;
            mSocket = IO.socket("http://node.cricnet.co.in:5001",opts);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public  Socket getmSocket() {
        return mSocket;
    }
}
