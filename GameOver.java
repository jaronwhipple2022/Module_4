package com.example.wanderingbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    Button mRestartButton;

    //define text views
    TextView tScore,tBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        mRestartButton = findViewById(R.id.btnplayAgain);

        // handle the scoring
        int scoreCount = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("myStoragePreference",0);
        int scoreBest = pref.getInt("scoreBest", 0);
        SharedPreferences.Editor edit = pref.edit();
        if (scoreCount > scoreBest){
            scoreBest = scoreCount;
            edit.putInt("scoreBest", scoreBest);
            edit.apply();
        }

        /* implement the functionality of the restart button. */
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GameOver.this,MainActivity.class);
                startActivity(myIntent);
            }
        });

        tScore = findViewById(R.id.scoreDisplay);
        tBest = findViewById(R.id.bestDisplay);
        tScore.setText(""+scoreCount);
        tBest.setText(""+scoreBest);
    }
}