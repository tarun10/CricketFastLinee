package com.learning.cricketfastline.socketconnection;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketConnection {

    private static Socket mSocket = null;

    private SocketConnection() {
    }
    public static Socket getSocketConnection() {
        if (mSocket == null) {
            try {
                mSocket = IO.socket("http://chat.socket.io");
            } catch (URISyntaxException e) {
            }
        }
        return mSocket;
    }
}
