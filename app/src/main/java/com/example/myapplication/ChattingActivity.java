package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChattingActivity extends AppCompatActivity {

    Activity thisactivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        TextView txtview = (TextView)findViewById(R.id.textView2);

        Button btn1 = (Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, OrderStatusActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.button4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, PopupActivity.class);
                startActivity(intent);
            }
        });

    }
}
