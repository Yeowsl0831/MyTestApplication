package com.example.prn763.mytestapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button playBtn;
    private MediaPlayer mediaPlayer;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.play);
        View.OnClickListener playToneListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Timer timer = new Timer(5) {
                    @Override
                    public void processTimerEvent() {

                    }
                };
                timer.startTimer();


            }
        };
        playBtn.setOnClickListener(playToneListener);


        MySensorManager sensorMgr = new MySensorManager(this) {
            @Override
            public void processSensorUIUpdateEvent() {

            }
        };
        sensorMgr.launchSensor();
    }

    private void gotoHomeScreen(){
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    public void playToneWarning(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.my_music);
        mediaPlayer.start();
    }
    public void stopToneWarning(){
        if(mediaPlayer != null && mediaPlayer.isPlaying() == true){
            mediaPlayer.stop();
        }
    }
}
