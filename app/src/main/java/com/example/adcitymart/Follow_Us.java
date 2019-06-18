package com.example.adcitymart;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Follow_Us extends AppCompatActivity
{
    ImageButton face,insta,twitter,linked;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_follow__us);
        findViewById(R.id.cardbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                website(v);

            }
        });
        findViewById(R.id.facebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                facebook(v);

            }
        });
        findViewById(R.id.twitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                twitter(v);
            }
        });
        findViewById(R.id.instagram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Instagram(v);
            }
        });
        findViewById(R.id.Skype).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Skype(v);

            }
        });
        findViewById(R.id.linkedid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                linked(v);
            }
        });
    }

    private void website(View v)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.adcitymart.com"));
        startActivity(intent);
    }

    public void Instagram(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.instagram.com/adcitymart/"));
            startActivity(intent);

    }

    public void linked(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.linkedin.com/adcitymart/"));
        startActivity(intent);
    }

    public void twitter(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.twitter.com/adcity2/"));
        startActivity(intent);
    }

    public void facebook(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/adcitymart/"));
        startActivity(intent);
    }

    public void Skype(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.Skype.com/adcitymart/"));
        startActivity(intent);
    }
}
