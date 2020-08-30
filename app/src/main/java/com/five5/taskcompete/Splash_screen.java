package com.five5.taskcompete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_screen extends AppCompatActivity {
    Animation fadein;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        fadein= AnimationUtils.loadAnimation(this,R.anim.a);
        logo=(ImageView) findViewById(R.id.logo_splash);
        logo.setAnimation(fadein);
        logo.startAnimation(fadein);
        fadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash_screen.this,LoginPage.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}