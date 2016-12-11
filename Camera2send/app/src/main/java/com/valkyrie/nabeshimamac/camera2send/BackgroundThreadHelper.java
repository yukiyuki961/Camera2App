package com.valkyrie.nabeshimamac.camera2send;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by NabeshimaMAC on 2016/12/11.
 */

public class BackgroundThreadHelper {
    private static final String TAG = "BackgroundThreadHelper";

    private HandlerThread mThread = null;
    private Handler mHandler = null;

    public BackgroundThreadHelper() {
        return;
    }

    public void start() {
        mThread = new HandlerThread("CameraBackground");
        mThread.start();
        mHandler = new Handler(mThread.getLooper());
    }

    public Handler getHandler() {
        if (mHandler == null) {
            Log.e(TAG, "BackgroundThread Error mHandler null");
        }
        return mHandler;
    }

    public void stop() {
        mThread.quitSafely();
        try {
            mThread.join();
            mThread = null;
            mHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
