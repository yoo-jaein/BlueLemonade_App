package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    private Handler handlers;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();

        handlers.postDelayed(runnable, 3000);

    }


    public void init() {
        handlers = new Handler();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        handlers.removeCallbacks(runnable);
    }

}