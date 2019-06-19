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

public class Blog extends AppCompatActivity
{
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference ecomm=database.getReference("Blog/E-commerce and Digital marketing");
    DatabaseReference eadver=database.getReference("Blog/E-mail advertising");
    DatabaseReference mobile=database.getReference("Blog/Mobile vs desktop ");
    DatabaseReference scale=database.getReference("Blog/Scale_up");
    DatabaseReference startup=database.getReference("Blog/Start_Up");
    DatabaseReference breakdown=database.getReference("Blog/breakdown");
    DatabaseReference consider=database.getReference("Blog/consideration");
    DatabaseReference fund=database.getReference("Blog/fund");

    DatabaseReference desk_adv=database.getReference("Blog/desktop");
TextView textView_scaleup,textView_ecom,textView_mail,textView_mobile,textView_startUp,textView_breakdown,textView_consideration,textView_funding,textView_desktop;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_blog);
        textView_scaleup=findViewById(R.id.id_scaleUp);
        textView_ecom=findViewById(R.id.id_vs);
        textView_mail=findViewById(R.id.id_emailadvertisement);
        textView_mobile=findViewById(R.id.id_mobile_adver);
        textView_startUp=findViewById(R.id.id_startup);
        textView_breakdown=findViewById(R.id.id_breakdown);
        textView_consideration=findViewById(R.id.id_consideration);
        textView_funding=findViewById(R.id.id_funding);
        textView_desktop=findViewById(R.id.id_desktop);
        fetch();
    }

    private void fetch()
    {
    desk_adv.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
        {
            String val=dataSnapshot.getValue(String.class);
            textView_desktop.setText(val);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError)
        {
            Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();
        }
    });
        breakdown.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String val=dataSnapshot.getValue(String.class);
                textView_breakdown.setText(val);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
        consider.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String vla=dataSnapshot.getValue(String.class);
                textView_consideration.setText(vla);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();

            }
        });
        fund.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String val=dataSnapshot.getValue(String.class);
                textView_funding.setText(val);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
        startup.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String val=dataSnapshot.getValue(String.class);
                textView_startUp.setText(val);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();

            }
        });
      ecomm.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
             String val=dataSnapshot.getValue(String.class);
             textView_ecom.setText(val);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();

          }
      }) ;
      eadver.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String val=dataSnapshot.getValue(String.class);
              textView_mail.setText(val);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();
          }
      });
      mobile.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String val=dataSnapshot.getValue(String.class);
              textView_mobile.setText(val);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();
          }
      });
      scale.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String val=dataSnapshot.getValue(String.class);
              textView_scaleup.setText(val);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(Blog.this, "No internet", Toast.LENGTH_SHORT).show();

          }
      });
    }
}
