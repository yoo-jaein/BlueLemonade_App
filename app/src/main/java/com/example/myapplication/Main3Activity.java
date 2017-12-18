package com.example.myapplication;

/*
    Main3Activity
    intent로 받은 brand의 menu 동적 생성
*/

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.SystemClock.sleep;

public class Main3Activity extends AppCompatActivity {

    Activity thisactivity = this;

    Constants.CHICKEN[] chickens = Constants.CHICKEN.values();
    Constants.PIZZA[] pizzas = Constants.PIZZA.values();

    int category_num = -1;  // category 저장: CHICKEN(0), PIZZA(1)
    int brand_num = -1;     // brand 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView txt = (TextView)findViewById(R.id.category_brand_txtview);

        Intent intent = getIntent();
        String c_data = intent.getStringExtra("category");
        String b_data = intent.getStringExtra("brand");

        final LinearLayout lm = (LinearLayout)findViewById(R.id.ll);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if(c_data.equals("chicken")) {
            category_num = 0;
            txt.setText(b_data);

            for(int i = 0; i < chickens.length; i++) {
                if(b_data.equals(chickens[i].str))
                    brand_num = i;
            }

            if(b_data.equals("BBQ")) {
                Constants.BBQ[] bbqs = Constants.BBQ.values();

                for (int j = 0; j < bbqs.length; j++) {
                    // LinearLayout 생성
                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    // TextView 생성
                    TextView price = new TextView(this);
                    price.setText(bbqs[j].price + "원     ");

                    ll.setGravity(Gravity.RIGHT);
                    ll.addView(price);

                    ll.setBackgroundColor(Color.rgb(255, 255, 255));

                    // 버튼 생성
                    final Button btn = new Button(this);

                    // setId 버튼에 대한 키값
                    btn.setId(j);
                    btn.setText(bbqs[j].str);
                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(Color.rgb(255, 230, 108));

                    final int position = j;
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "화면 하단의 주문 방법을 선택하세요.", Toast.LENGTH_LONG).show();
                            btn.setBackgroundColor(Color.rgb(185,153,0));
                        }
                    });

                    //버튼 add
                    ll.addView(btn);

                    //LinearLayout 정의된거 add
                    lm.addView(ll);
                }
            } else if(b_data.equals("네네치킨")) {
                Constants.NENE[] nenes = Constants.NENE.values();

                for (int j = 0; j < nenes.length; j++) {
                    // LinearLayout 생성
                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    // TextView 생성
                    TextView price = new TextView(this);
                    price.setText(nenes[j].price + "원     ");

                    ll.setGravity(Gravity.RIGHT);
                    ll.addView(price);

                    ll.setBackgroundColor(Color.rgb(255, 255, 255));

                    // 버튼 생성
                    final Button btn = new Button(this);

                    // setId 버튼에 대한 키값
                    btn.setId(j);
                    btn.setText(nenes[j].str);
                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(Color.rgb(255, 230, 108));

                    final int position = j;
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "화면 하단의 주문 방법을 선택하세요.", Toast.LENGTH_LONG).show();
                            btn.setBackgroundColor(Color.rgb(185,153,0));
                        }
                    });

                    //버튼 add
                    ll.addView(btn);

                    //LinearLayout 정의된거 add
                    lm.addView(ll);
                }
            }
        }


        if(c_data.equals("pizza")) {
            category_num = 1;
            txt.setText(b_data);

            for(int i = 0; i < pizzas.length; i++) {
                if(b_data.equals(pizzas[i].str))
                    brand_num = i;
            }

            if(b_data.equals("네오피자")) {
                Constants.NEOPIZZA[] neopizzas = Constants.NEOPIZZA.values();

                for (int j = 0; j < neopizzas.length; j++) {
                    // LinearLayout 생성
                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    // TextView 생성
                    TextView price = new TextView(this);
                    price.setText(neopizzas[j].price + "원     ");

                    ll.setGravity(Gravity.RIGHT);
                    ll.addView(price);

                    ll.setBackgroundColor(Color.rgb(255, 255, 255));

                    // 버튼 생성
                    final Button btn = new Button(this);

                    // setId 버튼에 대한 키값
                    btn.setId(j);
                    btn.setText(neopizzas[j].str);
                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(Color.rgb(255, 230, 108));

                    final int position = j;
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "화면 하단의 주문 방법을 선택하세요.", Toast.LENGTH_LONG).show();
                            btn.setBackgroundColor(Color.rgb(185,153,0));
                        }
                    });

                    //버튼 add
                    ll.addView(btn);

                    //LinearLayout 정의된거 add
                    lm.addView(ll);
                }
            } else if(b_data.equals("피자빙고")) {
                Constants.PIZZABINGO[] pizzabingos = Constants.PIZZABINGO.values();

                for (int j = 0; j < pizzabingos.length; j++) {
                    // LinearLayout 생성
                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    // TextView 생성
                    TextView price = new TextView(this);
                    price.setText(pizzabingos[j].price + "원     ");

                    ll.setGravity(Gravity.RIGHT);
                    ll.addView(price);

                    ll.setBackgroundColor(Color.rgb(255, 255, 255));

                    // 버튼 생성
                    final Button btn = new Button(this);

                    // setId 버튼에 대한 키값
                    btn.setId(j);
                    btn.setText(pizzabingos[j].str);
                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(Color.rgb(255, 230, 108));

                    final int position = j;
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "화면 하단의 주문 방법을 선택하세요.", Toast.LENGTH_LONG).show();
                            btn.setBackgroundColor(Color.rgb(185,153,0));
                        }
                    });

                    //버튼 add
                    ll.addView(btn);

                    //LinearLayout 정의된거 add
                    lm.addView(ll);
                }
            }
        }


        ImageButton auto_matching_btn = (ImageButton)findViewById(R.id.auto_matching_button);
        auto_matching_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, ChattingActivity.class);
                startActivity(intent);
            }
        });

        ImageButton create_room_btn = (ImageButton)findViewById(R.id.create_room_button);
        create_room_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, ChattingActivity.class);
                startActivity(intent);
            }
        });

       /* FloatingActionButton floating_back_btn = (FloatingActionButton)findViewById(R.id.floating_back_button);
        floating_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }
}
