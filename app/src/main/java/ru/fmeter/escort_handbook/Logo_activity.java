package ru.fmeter.escort_handbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Logo_activity extends Activity {
    private Animation logoAnim;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity(2);
    }

    private void init(){
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);
        logoImage = findViewById(R.id.imageView);
        logoImage.startAnimation(logoAnim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void startMainActivity(int sec){
        final int secThread = sec * 1000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(secThread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Logo_activity.this, MainActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}
