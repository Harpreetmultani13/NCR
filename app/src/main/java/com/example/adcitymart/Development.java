package com.example.adcitymart;

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

public class Development extends AppCompatActivity
{
    TextView textView_web,textView_andoid,textView_cms,textView_erp,textView_ecomm,textView_java;
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
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_development);
        Fetch_Andoid();
        Fetch_E_comm();
        Fetch_CMS();
        Fetch_ERP();
        Fetch_JAVA();
        textView_andoid=findViewById(R.id.id_andoid);
       // textView_web=findViewById(R.id.id_web);
        textView_cms=findViewById(R.id.id_cms);
        textView_erp=findViewById(R.id.id_erp);
        textView_ecomm=findViewById(R.id.id_ecommerce);
        textView_java=findViewById(R.id.id_java);


    }

    private void Fetch_JAVA()
    {
        java.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               String java=dataSnapshot.getValue(String.class);
               textView_java.setText(java);
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
              textView_erp.setText(erp);
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
               textView_cms.setText(cms);
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
              textView_ecomm.setText(ecom);
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
                textView_andoid.setText(android);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Development.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
