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

public class Development extends AppCompatActivity
{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference andoid=database.getReference("Develop/Android");
    DatabaseReference E_Commerce=database.getReference("Develop/E-Commerce");
    DatabaseReference cms=database.getReference("Develop/CMS");
    DatabaseReference erp=database.getReference("Develop/ERP");
    DatabaseReference java=database.getReference("Develop/Java");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development);
        Fetch_Andoid();
        Fetch_E_comm();
        Fetch_CMS();
        Fetch_ERP();
        Fetch_JAVA();


    }

    private void Fetch_JAVA()
    {
        java.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String java=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_ERP()
    {
        erp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              String erp=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_CMS()
    {
        cms.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String cms=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Fetch_E_comm()
    {
        E_Commerce.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              String ecom=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Andoid()
    {
        andoid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String  android=dataSnapshot.getValue(String.class);
                Toast.makeText(Development.this, "ANDROID == "+android, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
