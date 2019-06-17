package com.example.adcitymart;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

public class Intership extends AppCompatActivity
{

    TextView textView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Internship/");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        fetchdata();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intership);

        textView=findViewById(R.id.internshipid);


    }



    private void fetchdata()
    {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String Internship =dataSnapshot.getValue(String.class);
               // Toast.makeText(Intership.this, "Value is"+Internship, Toast.LENGTH_SHORT).show();
                textView.setText(Internship);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Intership.this, "Not possible", Toast.LENGTH_SHORT).show();

            }
        });
    }


}

