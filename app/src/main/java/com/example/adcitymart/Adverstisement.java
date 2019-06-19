package com.example.adcitymart;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Adverstisement extends AppCompatActivity
{
    FirebaseStorage storage;
    StorageReference reference;
    ImageView imageView1,imageView2;
    TextView textView_display,textView_social,textView_newspaper,textView_outdoor,textView_radio,textView_email,textView_video,textView_google,textView_pp;

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
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_adverstisement);
        imageView1=findViewById(R.id.one);
        imageView2=findViewById(R.id.two);
        textView_display=findViewById(R.id.id_display);
        textView_social=findViewById(R.id.social);
        textView_newspaper=findViewById(R.id.news);
        textView_outdoor=findViewById(R.id.outdoor);
        textView_radio=findViewById(R.id.radio);
        textView_email=findViewById(R.id.id_email);
        textView_video=findViewById(R.id.id_video);
      //  textView_google=findViewById(R.id.id_google);
        textView_pp=findViewById(R.id.id_PP);
        Fetch_Advertisement_Display_Ads();
        Fetch_Advertisement_Email();
        Fetch_Advertisement_Newspaper_Ads();
        Fetch_Advertisement_Outdoor_Ads();
        Fetch_Advertisement_Product_Placement();
        Fetch_Advertisement_Social_Media_Ads();
        Fetch_Advertisement_Video_Ads();
        Fetch_Advertisement_Radio();
            FetchImage();


    }

    private void FetchImage()
    {
        storage= FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://adcitymart-9095a.appspot.com");
        StorageReference fisrt=reference.child("vehiclead1.jpg");
        File myfile=null;
        try
        {
            myfile=File.createTempFile("images",".jpg");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile1=myfile;
        fisrt.getFile(myfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile1.getAbsolutePath());
                imageView1.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(Adverstisement.this, "Fetching .....", Toast.LENGTH_SHORT).show();

            }
        });
        StorageReference second=reference.child("vehiclead2.jpg");
        File myfile2=null;
        try
        {
            myfile2=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfilefile2=myfile2;
        second.getFile(myfile2).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfilefile2.getAbsolutePath());
                imageView2.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(Adverstisement.this, "Fetching ....", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void Fetch_Advertisement_Radio()
    {
        Advertisement_Radio.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String Radio=dataSnapshot.getValue(String.class);
                textView_radio.setText(Radio);

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
                textView_video.setText(video);
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
                textView_social.setText(social);
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
                textView_pp.setText(pp);
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
                textView_outdoor.setText(outdoor);

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
                    textView_newspaper.setText(newspaper);

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
               textView_email.setText(Advertisement_Email);

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
                textView_display.setText(Advertisement_Display_Ads);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Adverstisement.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }




}
