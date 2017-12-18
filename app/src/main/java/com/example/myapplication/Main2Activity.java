package com.example.myapplication;

/*
    Main2Activity
    TextView intent로 받은 category 출력
    intent로 받은 category의 brand 동적 생성
*/

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        final LinearLayout lm = (LinearLayout)findViewById(R.id.ll);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        for(int j = 0; j < Constants.CHICKEN.values().length; j++) {
            // LinearLayout 생성
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            // TextView 생성
            TextView brand_txt = new TextView(this);
            brand_txt.setText("Name" + j + " ");
            ll.addView(brand_txt);

            // TextView 생성
            TextView tvAge = new TextView(this);
            tvAge.setText("   Age" + j + "  ");
            ll.addView(tvAge);

            // 버튼 생성
            final Button btn = new Button(this);

            // setId 버튼에 대한 키값
            btn.setId(j + 1);
            btn.setText("Apply");
            btn.setLayoutParams(params);

            final int position = j;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("log", "position :" + position);
                    Toast.makeText(getApplicationContext(), "클릭한 position:" + position, Toast.LENGTH_LONG).show();
                }

            });
            //버튼 add
            ll.addView(btn);

            //LinearLayout 정의된거 add
            lm.addView(ll);
        }


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
