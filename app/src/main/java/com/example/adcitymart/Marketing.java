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

public class Marketing extends AppCompatActivity
{
    TextView textView_sco,textView_smo,textView_digital,textView_emails;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference digital=database.getReference("Marketing/Digital");
    DatabaseReference Email=database.getReference("Marketing/E-Mail");
    DatabaseReference smo=database.getReference("Marketing/SMO");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);
        textView_digital=findViewById(R.id.id_diddital);
        textView_emails=findViewById(R.id.id_mail_market);
        textView_smo=findViewById(R.id.id_smoo);
        textView_sco=findViewById(R.id.id_seo);
        Fetch_digital();
        Fetch_email();
        Fetch_smo();
    }

    private void Fetch_smo()
    {
        smo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String smo=dataSnapshot.getValue(String.class);
               textView_smo.setText(smo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Fetch_email()
    {
        Email.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String mail=dataSnapshot.getValue(String.class) ;
               textView_emails.setText(mail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void Fetch_digital()
    {
        digital.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String val=dataSnapshot.getValue(String.class);
                textView_digital.setText(val);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
