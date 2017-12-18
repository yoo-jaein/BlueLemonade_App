package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.myapplication.PhysicalArchitecture.Client;
import com.example.myapplication.PhysicalArchitecture.ClientControl;

public class IntroActivity extends AppCompatActivity {

    private Handler handlers;

    private Handler startHandler;

    private ClientControl cControl;

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

        cControl = cControl.getClientControl();
        cControl.getClient().start();
        cControl.start(35.890945, 128.611153);



        startHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                cControl.setStartHandler(null);
                if(msg.what== Constants.SUCCESS){
                    handlers.postDelayed(runnable, 3000);
                }
                else if(msg.what==Constants.FAIL){
                    Toast.makeText(getApplicationContext(), "해당 지역이 아니면 서비스를 이용할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        };
        cControl.setStartHandler(startHandler);
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