package com.example.prn763.mytestapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by PRN763 on 1/14/2018.
 */

public class VehicleSpeed extends AppCompatActivity implements LocationListener {
    private final static String TAG = "VehicleSpeed";
    private Location lastLocation = null;
    private TextView speedText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_speed);
        speedText = findViewById(R.id.speedText);

        lastLocation = null;

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);



    }

    @Override
    public void onLocationChanged(Location location) {

        double timeElapsed = 0;
        double distance = 0;

        if(location != null){
            if(lastLocation != null){
                //get time elapsed in sec
                timeElapsed = (location.getTime() - lastLocation.getTime())/(1000);
                //get distance elapsed in m
                distance = lastLocation.distanceTo(location);

                lastLocation = location;
            }
            else{
                lastLocation = location;
            }

            int speed = (int)((distance/timeElapsed)*(18/5));

            if(speedText != null){
                speedText.setText("Time:"+timeElapsed+"s"+ ", Distance:"+distance+"m [Speed:"+speed+"km/h]");
            }

        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
