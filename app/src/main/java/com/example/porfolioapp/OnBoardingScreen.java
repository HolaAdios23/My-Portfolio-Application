package com.example.porfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnBoardingScreen extends AppCompatActivity {

    Button next;
    TextView number;
    Button skipbutton;
    FirstSlideFragment firstSlideFragment = new FirstSlideFragment();
    SecondSlideFragment secondSlideFragment = new SecondSlideFragment();
    ThirdSlideFragment thirdSlideFragment = new ThirdSlideFragment();

    boolean first = true;
    boolean second = false;

    boolean finished = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardingscreens);

        next = findViewById(R.id.nexttouch);
        number = findViewById(R.id.onboardingno);
        skipbutton = findViewById(R.id.skip_button);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, firstSlideFragment).commit();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String seconded = "2 Out Of 3";
                String thirded = "3 Out Of 3";
                if(first == true)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, secondSlideFragment).commit();
                     number.setText(seconded);
                    second = true;
                    first = false;

                }
                else if(second == true)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdSlideFragment).commit();
                    number.setText(thirded);
                    next.setText("Done");
                    finished = true;
                    second = false;
                }
                else if(finished == true)
                {
                    Intent intent = new Intent(OnBoardingScreen.this, Navigation.class);
                    startActivity(intent);
                }


            }


        });
        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingScreen.this, Navigation.class);
                startActivity(intent);
            }
        });


    }
}