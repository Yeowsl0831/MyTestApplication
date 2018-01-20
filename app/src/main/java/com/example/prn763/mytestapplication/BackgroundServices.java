package com.example.prn763.mytestapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by PRN763 on 1/12/2018.
 */

public class BackgroundServices extends Service {

    final static String TAG = "BackgroundService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timer timer = new Timer(20) {
            @Override
            public void processTimerEvent() {
                Log.d(TAG, "Im Process Timer Event");
                Intent intent = new Intent(BackgroundServices.this, MainActivity.class);
                startActivity(intent);
            }
        };
        timer.startTimer();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
