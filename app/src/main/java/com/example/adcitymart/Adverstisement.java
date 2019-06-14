package com.example.adcitymart;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Adverstisement extends AppCompatActivity
{


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Advertisement_Display_Ads = database.getReference("Advertisement/Display_Ads");
    DatabaseReference Advertisement_Email = database.getReference("Advertisement/E-Mail Ads");
    DatabaseReference Advertisement_Radio=database.getReference("Advertisement/Radio");
    DatabaseReference Advertisement_NewsPaper=database.getReference("Advertisement/Newspaper Ads");
    DatabaseReference Advertisement_Outdoor_Ads=database.getReference("Advertisement/Outdoor Ads");
    DatabaseReference Advertisement_PP=database.getReference("Advertisement/Product Placement");
    DatabaseReference Advertisement_Social=database.getReference("Advertisement/Social Media Ads");
    DatabaseReference Advertisement_Video=database.getReference("Advertisement/Video Ads");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverstisement);
        Fetch_Advertisement_Display_Ads();
        Fetch_Advertisement_Email();
        Fetch_Advertisement_Newspaper_Ads();
        Fetch_Advertisement_Outdoor_Ads();
        Fetch_Advertisement_Product_Placement();
        Fetch_Advertisement_Social_Media_Ads();
        Fetch_Advertisement_Video_Ads();
        Fetch_Advertisement_Radio();



    }

    private void Fetch_Advertisement_Radio()
    {
        Advertisement_Radio.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String Radio=dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Advertisement_Video_Ads()
    {
        Advertisement_Video.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String video=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Advertisement_Social_Media_Ads()
    {
        Advertisement_Social.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String social=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Advertisement_Product_Placement()
    {
        Advertisement_PP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String pp = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Advertisement_Outdoor_Ads()
    {
        Advertisement_Outdoor_Ads.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String outdoor=dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Fetch_Advertisement_Newspaper_Ads()
    {
            Advertisement_NewsPaper.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {
                    String newspaper=dataSnapshot.getValue(String.class);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError)
                {
                    Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();

                }
            });
    }


    private void Fetch_Advertisement_Email()
    {
        Advertisement_Email.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String Advertisement_Email=dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }





    private void Fetch_Advertisement_Display_Ads()
    {
        Advertisement_Display_Ads.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String Advertisement_Display_Ads=dataSnapshot.getValue(String.class);
                Toast.makeText(Adverstisement.this, "Advertisement Display_Ads  " + Advertisement_Display_Ads, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }




}
