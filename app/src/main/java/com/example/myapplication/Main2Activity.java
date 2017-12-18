package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Activity thisactivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt = (TextView)findViewById(R.id.category_txtview);

        Intent intent = getIntent();
        String data = intent.getStringExtra("category");

        if(data.equals("chicken"))
            txt.setText("치킨");
        if(data.equals("pizza"))
            txt.setText("피자");

        ImageButton auto_matching_btn = (ImageButton)findViewById(R.id.auto_matching_button);
        auto_matching_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, ChattingActivity.class);
                finish();
                startActivity(intent);
            }
        });

        ImageButton create_room_btn = (ImageButton)findViewById(R.id.create_room_button);
        create_room_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, ChattingActivity.class);
                finish();
                startActivity(intent);
            }
        });

        FloatingActionButton floating_back_btn = (FloatingActionButton)findViewById(R.id.floating_back_button);
        floating_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
