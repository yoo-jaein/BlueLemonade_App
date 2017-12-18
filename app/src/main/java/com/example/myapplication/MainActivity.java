package com.example.myapplication;

/*
    MainActivity
    spinner 학교, 기숙사
    category 치킨, 피자
*/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Activity thisactivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] str1 = getResources().getStringArray(R.array.univArray);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, str1);
        Spinner spi1 = (Spinner)findViewById(R.id.spinner);
        spi1.setAdapter(adapter1);
        spi1.setSelection(1);

        String[] str2 = getResources().getStringArray(R.array.dormArray);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, str2);
        Spinner spi2 = (Spinner)findViewById(R.id.spinner2);
        spi2.setAdapter(adapter2);
        spi2.setSelection(6);
        spi2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected
                            (AdapterView<?> parent, View view, int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        ImageButton chicken_btn = (ImageButton)findViewById(R.id.chicken_button);
        chicken_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, Main2Activity.class);
                intent.putExtra("category", "chicken");
                startActivity(intent);
            }
        });

        ImageButton pizza_btn = (ImageButton)findViewById(R.id.pizza_button);
        pizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, Main2Activity.class);
                intent.putExtra("category", "pizza");
                startActivity(intent);
            }
        });

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


        /* ImageButton location_btn = (ImageButton)findViewById(R.id.location_button);
        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisactivity, OrderStatusActivity.class);
                finish();
                startActivity(intent);
            }
        });*/
    }
}
