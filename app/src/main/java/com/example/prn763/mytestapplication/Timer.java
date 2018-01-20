package com.example.prn763.mytestapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by PRN763 on 1/12/2018.
 */

public abstract class Timer {
    private final static String TAG = "Timer";
    private int mTimeInSec;
    private boolean mEnabledTimer;

    //abstract methods
    abstract public void processTimerEvent();

    public Timer(int timeInSec){
        mTimeInSec = timeInSec;
        mEnabledTimer = false;
    }

    private void runTimer(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                while(mEnabledTimer){
                    try {
                        synchronized (this){
                            wait(mTimeInSec*1000);
                            processTimerEvent();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();
    }

    public void startTimer(){
        mEnabledTimer = true;
        runTimer();
    }


    public void stopTimer(){
        mEnabledTimer = false;
    }
}

