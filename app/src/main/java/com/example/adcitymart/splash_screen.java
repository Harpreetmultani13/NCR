package com.example.adcitymart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
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
        isLogin = preferences.getBoolean("Islogin",true);
        imageView=findViewById(R.id.splash);
        textView=findViewById(R.id.splashtext);
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Toast.makeText(this, ""+isLogin, Toast.LENGTH_SHORT).show();
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(!isLogin) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
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

}//done