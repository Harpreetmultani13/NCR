package com.example.adcitymart;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity
{
    Fragment fragment;
    BottomNavigationView bottomNavigationView;
    SharedPreferences preferences;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        frameLayout =findViewById(R.id.frame_layout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        fragment=null;
        fragment=new Home_Frag();
        if(fragment!=null)
        {
            FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,fragment);
            fragmentTransaction.commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                int id=item.getItemId();
                if(id==R.id.idhome)
                {
                    fragment=new Home_Frag();
                    Toast.makeText(Home.this, "Home", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.aboutus)
                {
                    fragment=new About_us();
                    Toast.makeText(Home.this, "About_us", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.idsevices)
                {
                    fragment=new Products();
                    Toast.makeText(Home.this, "Services", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.logout)
                {
                    logOutMethod();
                }
                if(fragment!=null)
                {
                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,fragment);
                    fragmentTransaction.commit();
                }

                return true;
            }
        });


    }


//ALERT DILAOG BOX For Exit

    @Override
    public void onBackPressed()
    {
        final AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("ARE YOU SURE TO EXIT");
        alert.setIcon(R.drawable.questionmark);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                    finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });
            alert.show();

    }


   







    //Method to log out

   private void logOutMethod()
    {
        auth=FirebaseAuth.getInstance();
            firebaseUser =auth.getCurrentUser();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("ARE YOU SURE TO LOG OUT");
        builder.setIcon(R.drawable.questionmark);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                auth.signOut();
                Intent intent=new Intent(Home.this,MainActivity.class);
                startActivity(intent);
                    preferences = PreferenceManager.getDefaultSharedPreferences(Home.this);
                    preferences.edit().putBoolean("Islogin",false).commit();
                        finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

    }
}



