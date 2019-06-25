package com.example.adcitymart;

import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Marketing extends AppCompatActivity
{
    TextView textView_sco,textView_smo,textView_digital,textView_emails,textView_m1,textView_m2,textView_m3,textView_m4,textView_m5,textView_m6;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference digital=database.getReference("Marketing/Digital");
    DatabaseReference Email=database.getReference("Marketing/E-Mail");
    DatabaseReference smo=database.getReference("Marketing/SMO");
    DatabaseReference m1=database.getReference("SEO/Month1");
    DatabaseReference m2=database.getReference("SEO/Month2");
    DatabaseReference m3=database.getReference("SEO/Month3");
    DatabaseReference m4=database.getReference("SEO/Month4");
    DatabaseReference m5=database.getReference("SEO/Month5");
    DatabaseReference m6=database.getReference("SEO/Month6");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_marketing);
        textView_digital=findViewById(R.id.id_diddital);
        textView_emails=findViewById(R.id.id_mail_market);
        textView_smo=findViewById(R.id.id_smoo);
        textView_m1=findViewById(R.id.id_Month1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textView_m2=findViewById(R.id.id_Month2);
        textView_m3=findViewById(R.id.id_Month3);
        textView_m4=findViewById(R.id.id_Month4);
        textView_m5=findViewById(R.id.id_Month5);
        textView_m6=findViewById(R.id.id_Month6);

        Fetch_digital();
        Fetch_email();
        Fetch_smo();
        Fetch_Month();
    }

    private void Fetch_Month()
    {
        m1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String one=dataSnapshot.getValue(String.class);
                textView_m1.setText(one);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        m2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String two=dataSnapshot.getValue(String.class);
               textView_m2.setText(two);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
        m3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
             String three=dataSnapshot.getValue(String.class);
             textView_m3.setText(three);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        m4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String four=dataSnapshot.getValue(String.class);
                textView_m4.setText(four);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        m5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String five=dataSnapshot.getValue(String.class);
                textView_m5.setText(five);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        m6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              String six=dataSnapshot.getValue(String.class);
              textView_m6.setText(six);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Marketing.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
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
