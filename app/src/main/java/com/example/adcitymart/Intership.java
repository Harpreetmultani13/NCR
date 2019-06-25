package com.example.adcitymart;

import android.content.pm.ActivityInfo;
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
import com.google.firebase.database.core.view.View;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Intership extends AppCompatActivity
{
    FirebaseStorage storage;
    StorageReference reference;
    ImageView imageView1,imageView2,imageView3;

    TextView textView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Internship/");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intership);
        Imageinit();

        fetchdata();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView=findViewById(R.id.internshipid);
        imageView1=findViewById(R.id.one);
        imageView2=findViewById(R.id.two);
        imageView3=findViewById(R.id.three);


    }

    private void Imageinit()
    {
        storage= FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://adcitymart-9095a.appspot.com");
        StorageReference fisrt=reference.child("intern1.jpg");
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

            }
        });


        StorageReference second=reference.child("intern2.jpg");
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
                Toast.makeText(Intership.this, "Fetching Data ....", Toast.LENGTH_SHORT).show();

            }
        });
        StorageReference third=reference.child("intern3.jpg");
        File myfile3=null;
        try {
            myfile3=File.createTempFile("images",".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final  File finalfile3=myfile3;
        third.getFile(myfile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile3.getAbsolutePath());
                imageView3.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });

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

