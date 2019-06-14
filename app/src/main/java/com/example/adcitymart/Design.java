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

public class Design extends AppCompatActivity
{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Design_Logo=database.getReference("Design/Logo_Designing");
    DatabaseReference Design_DDD=database.getReference("Design/3D Modelling and Designing");
    DatabaseReference Design_Graphics=database.getReference("Design/Graphic_Designing");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        Fetch_Design_DDD();
        Fetch_Design_Logo();
        Fetch_Design_Graphics();

    }

    private void Fetch_Design_Graphics()
    {
        Design_Graphics.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String val=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Design.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Design_Logo()
    {
        Design_Logo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String logo=dataSnapshot.getValue(String.class);
                Toast.makeText(Design.this, "Value  "+logo, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Design.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Fetch_Design_DDD()
    {
        Design_DDD.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String ddd=dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Design.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
