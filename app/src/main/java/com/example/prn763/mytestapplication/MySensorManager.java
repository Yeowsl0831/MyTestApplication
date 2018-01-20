package com.example.prn763.mytestapplication;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by PRN763 on 1/14/2018.
 */

public abstract class MySensorManager implements SensorEventListener {
    abstract public void processSensorUIUpdateEvent();

    private final static String TAG = "MySensorManager";
    private Context context;
    private SensorManager sensorManager;

    MySensorManager(Context contxt){
        context = contxt;
    }

    public void launchSensor(){
        sensorManager = (SensorManager)context.getSystemService(SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopSensor(){
        if(sensorManager != null){
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "X People Touch My Phone Yet");
        if(sensorEvent.values[0] > 0.0 || sensorEvent.values[1] > 10 || sensorEvent.values[2] > 0.0){
            Log.d(TAG, "Some People Touch My Phone and close it down");
            processSensorUIUpdateEvent();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
