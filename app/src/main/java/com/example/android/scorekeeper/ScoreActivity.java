package com.example.android.scorekeeper;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView homeTeam_name;
    TextView guestTeam_name;
    TextView home_pts;
    TextView guest_pts;
    private Chronometer chronometer;
    boolean isRunning;
    private long pauseOffset;
    int home_score;
    int guest_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //Getting the team names inputted in the first activity to be display un the second activity
        homeTeam_name = findViewById(R.id.homeTeam_name);
        guestTeam_name = findViewById(R.id.guestTeam_name);
        String homeTeam = getIntent().getStringExtra("home");
        String awayTeam = getIntent().getStringExtra("guest");
        homeTeam_name.setText(homeTeam);
        guestTeam_name.setText(awayTeam);

        chronometer = findViewById(R.id.chronometer);
    }
    //setting the chronometer to start and reset
    public void startTimer(View v){
        if (!isRunning){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            isRunning= true;
        }
    }
    public void pauseTimer(View v){
        chronometer.stop();
        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
        isRunning = false;
    }
    public void restTimer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
    //set the button to add the points when the button is clicked (lines 54-102)
    public void touch_down_home(View v){
        home_score = home_score + 6;
        displayForHome(home_score);
    }

    public void field_goal_home(View v){
        home_score = home_score + 3;
        displayForHome(home_score);
    }

    public void safety_home(View v){
        home_score = home_score + 2;
        displayForHome(home_score);
    }

    public void extra_pts_home(View v){
        home_score = home_score + 1;
        displayForHome(home_score);
    }

    public void displayForHome(int score){
        TextView homeScore = findViewById(R.id.home_pts);
        homeScore.setText(String.valueOf(score));
    }

    public void touch_down_away(View v){
        guest_score = guest_score + 6;
        displayForGuest(guest_score);
    }

    public void field_goal_away(View v){
        guest_score = guest_score + 3;
        displayForGuest(guest_score);
    }

    public void safety_away(View v){
        guest_score = guest_score + 2;
        displayForGuest(guest_score);
    }

    public void extra_pts_away(View v){
        guest_score = guest_score + 1;
        displayForGuest(guest_score);
    }

    public void displayForGuest(int score){
        TextView guestScore = findViewById(R.id.guest_pts);
        guestScore.setText(String.valueOf(score));
    }

    public void reset(View v){
        home_score = 0;
        guest_score = 0;
        displayForHome(home_score);
        displayForGuest(guest_score);
    }
}
