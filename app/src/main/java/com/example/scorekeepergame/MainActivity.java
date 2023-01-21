package com.example.scorekeepergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;

    private TextView score1TV;
    private TextView score2TV;

    private ImageButton minusT1Button;
    private ImageButton plusT1Button;
    private ImageButton minusT2Button;
    private ImageButton plusT2Button;

    private static final String STATE_SCORE_1 = "SCORE_1";
    private static final String STATE_SCORE_2 = "SCORE_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.score1 = 0;
        this.score2 = 0;

        this.score1TV = findViewById(R.id.score_1);
        this.score2TV = findViewById(R.id.score_2);

        this.minusT1Button = findViewById(R.id.decreaseTeam1);
        this.plusT1Button = findViewById(R.id.increaseTeam1);;
        this.minusT2Button = findViewById(R.id.decreaseTeam2);
        this.plusT2Button = findViewById(R.id.increaseTeam2);

        this.minusT1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });

        this.plusT1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {increaseScore(v);}
        });

        this.minusT2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });

        this.plusT2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(v);
            }
        });


        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);
            score1TV.setText(String.valueOf(score1));
            score2TV.setText(String.valueOf(score2));
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                if(score1>0){
                    this.score1--;
                    this.score1TV.setText(String.valueOf(score1));
                }
                break;

            case R.id.decreaseTeam2:
                if(score2>0) {
                    this.score2--;
                    this.score2TV.setText(String.valueOf(score2));
                }
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                this.score1++;
                this.score1TV.setText(String.valueOf(score1));
                break;

            case R.id.increaseTeam2:
                this.score2++;
                this.score2TV.setText(String.valueOf(score2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }

}