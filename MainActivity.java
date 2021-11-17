package com.example.wanderingbear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppHolder.assign(this.getApplicationContext());
    }

    //when user clicks play button, this method is called
    public void startGame(View view)
    {
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
        finish();
    }
}