package com.example.adcitymart;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class splash_screen extends AppCompatActivity
{
    ImageView imageView;
    TextView textView;
    boolean isLogin  ;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(splash_screen.this);
        isLogin = preferences.getBoolean("Islogin",false);
        imageView=findViewById(R.id.splash);
        textView=findViewById(R.id.splashtext);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
       // overridePendingTransition(R.anim.transion, R.anim.out);
        Toast.makeText(this, ""+isLogin, Toast.LENGTH_SHORT).show();
        final Thread thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(!isLogin) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        //ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(splash_screen.this,findViewById(R.id.splash),"splashshared");
                        //startActivity(intent,optionsCompat.toBundle());
                        finish();
                    }
                    else if(isLogin)
                    {
                        Intent intent = new Intent(getApplicationContext(), Not_Verified.class);
                        startActivity(intent);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };
thread.start();



    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.transion,R.anim.out);
    }*/
}//done okk