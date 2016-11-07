package com.cs442.besecure.besecure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView im;
    Animation an;
    static int c = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = (ImageView) findViewById(R.id.img1);
        an = AnimationUtils.loadAnimation(this, R.anim.anim);
        an.reset();
        im.startAnimation(an);

        // METHOD 1

        /****** Create Thread that will sleep for 5 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(7 * 1000);

                    // After 5 seconds redirect to another intent
                    Log.d("Calling", "UserRegistration");
                    Intent i = new Intent(getBaseContext(), UserRegistration.class);
                    startActivity(i);

                    // Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
