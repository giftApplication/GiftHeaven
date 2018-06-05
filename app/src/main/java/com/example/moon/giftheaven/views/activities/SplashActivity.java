package com.example.moon.giftheaven.views.activities;

/**
 * Created by HP on 6/5/2018.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.moon.giftheaven.R;

public class SplashActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Animation anim,top,down;
    ImageView img;
    TextView t1, t2;
    Thread splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        lottieAnimationView.setImageAssetsFolder("assets/");
        lottieAnimationView.setAnimation("preloader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();


        img = findViewById(R.id.imageView);
        t1= findViewById(R.id.splash_text);
        t2= findViewById(R.id.tag_text);

        anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        top= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);

        img.startAnimation(top);
        t1.startAnimation(down);
        lottieAnimationView.startAnimation(down);
        t2.startAnimation(anim);



        splash = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(3200);
                    Intent myIntent = new Intent(getApplicationContext(),Activity1.class);
                    startActivity(myIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        splash.start();

    }
}

