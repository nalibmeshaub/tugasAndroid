package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class TopUp extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        } runTimer();

        ImageView mainList = (ImageView) findViewById(R.id.backBtn);
        mainList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meme = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(meme);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) running = true;
    }

    public void onClickStart (View view){
        running = true;
    }

    public void onClickStop (View view){
        running = false;
    }

    public void onClickReset (View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.serviceView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes =  (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault()
                        ,"%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if(running) seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }
}