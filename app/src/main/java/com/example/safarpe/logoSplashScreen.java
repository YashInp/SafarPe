package com.example.safarpe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class logoSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logosplashscreen); // your splash layout with logo

        ImageView logo = findViewById(R.id.logo);

        // Load and start the scale animation
        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_logo);
        logo.startAnimation(scaleAnim);

        // After 2 seconds, go to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(logoSplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
