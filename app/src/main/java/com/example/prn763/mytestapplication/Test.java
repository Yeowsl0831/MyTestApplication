package com.example.prn763.mytestapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by PRN763 on 1/12/2018.
 */

public class Test extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //start the service
        Intent intent = new Intent(this, BackgroundServices.class);
        startService(intent);
        //send the notification to notify users the app is running.
        sendNotification();
        //shutdown the activity and let the service is running background.
        finish();
    }

    public void sendNotification() {
        NotificationCompat.Builder notify = new NotificationCompat.Builder(this);
        notify.setSmallIcon(R.drawable.ic_time_to_leave_black_24dp);
        notify.setContentTitle("Life Savior");
        notify.setContentText("is Running...");

        Intent resultIntent = new Intent(this, Test.class);

        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notify.setContentIntent(resultPendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, notify.build());
    }

}
