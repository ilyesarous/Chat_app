package com.example.chatapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.chatapp.R;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 2500;
    TextView welcome;
    Animation top;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        welcome = findViewById(R.id.welcome);

        top = AnimationUtils.loadAnimation(this, R.anim.top);

        welcome.setAnimation(top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);


    }
}