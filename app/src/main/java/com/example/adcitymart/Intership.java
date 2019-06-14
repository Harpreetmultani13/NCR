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
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
       // init();
       // ftechdata();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intership);

    }
  /*  private void init()
    {
        textView=(TextView)findViewById(R.id.internshipid);
    }

    private void ftechdata()
    {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("adcitymart-9095a").child("Intership");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=(dataSnapshot.child("Intership").getValue().toString());
                Toast.makeText(Intership.this, "U enter "+s, Toast.LENGTH_SHORT).show();
                textView.setText(dataSnapshot.child("Intership").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Intership.this, "Make Sure that u r Connected to internship", Toast.LENGTH_SHORT).show();

            }
        });

    }
*/

}
