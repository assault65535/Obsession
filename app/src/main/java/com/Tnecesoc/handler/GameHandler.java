package com.Tnecesoc.handler;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Tnecesoc on 2016/7/7.
 */
public class GameHandler extends Handler {

    public static final int RIGHT_MOVE = 1;
    public static final int WRONG_MOVE = 2;


    @Override
    public void handleMessage(Message msg) {

        switch (msg.what) {
            case GameHandler.RIGHT_MOVE:
                break;
            case GameHandler.WRONG_MOVE:
                break;
            default:
                break;
        }
    }
}
