package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {
    ImageView bgImg,logo;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        bgImg=findViewById(R.id.bgImg);
        logo=findViewById(R.id.imageView2);
        lottieAnimationView= findViewById(R.id.lottie);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Intro.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2100);

        bgImg.animate().translationY(0).setDuration(0).setStartDelay(0);
        logo.animate().translationY(0).setDuration(0).setStartDelay(0);
        lottieAnimationView.animate().translationY(0).setDuration(0).setStartDelay(0);
    }
}