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
    TextView textView_display,textView_social,textView_newspaper,textView_outdoor,textView_radio,textView_email,textView_video,textView_televiosn,textView_pp;
    ImageView mailimage,mailimag2,disimage1,disimage2,socialimage1,socialimage2,news1,news2,outdoor1,outdoor2,video1,video2,event1,event2;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Advertisement_Display_Ads = database.getReference("Advertisement/Display_Ads");
    DatabaseReference Advertisement_Email = database.getReference("Advertisement/E-Mail Ads");
    DatabaseReference Advertisement_Radio=database.getReference("Advertisement/Radio");
    DatabaseReference Advertisement_NewsPaper=database.getReference("Advertisement/Newspaper Ads");
    DatabaseReference Advertisement_Outdoor_Ads=database.getReference("Advertisement/Outdoor Ads");
    DatabaseReference Advertisement_PP=database.getReference("Advertisement/Product Placement");
    DatabaseReference Advertisement_Social=database.getReference("Advertisement/Social Media Ads");
    DatabaseReference Advertisement_Video=database.getReference("Advertisement/Video Ads");
    DatabaseReference Advertisement_televisiosn=database.getReference("Advertisement/Television");




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverstisement);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mailimage=findViewById(R.id.idemailimage1);
        mailimag2=findViewById(R.id.idemailiamge2);
        disimage1=findViewById(R.id.iddisads1);
        disimage2=findViewById(R.id.iddisads2);
        event1=findViewById(R.id.idevent1);
        event2=findViewById(R.id.idevent2);
        socialimage1=findViewById(R.id.idsocalads1);
        socialimage2=findViewById(R.id.idsocialads2);
        news1=findViewById(R.id.idnews1);
        news2=findViewById(R.id.idnews2);
        outdoor1=findViewById(R.id.idoutdoor1);
        outdoor2=findViewById(R.id.idoutdoor2);
        video1=findViewById(R.id.idvideo1);
        video2=findViewById(R.id.idvideo2);
        imageView1=findViewById(R.id.one);
        imageView2=findViewById(R.id.two);
        textView_display=findViewById(R.id.id_display);
        textView_social=findViewById(R.id.social);
        textView_newspaper=findViewById(R.id.news);
        textView_outdoor=findViewById(R.id.outdoor);
        textView_radio=findViewById(R.id.radio);
        textView_email=findViewById(R.id.id_email);
        textView_video=findViewById(R.id.id_video);
        textView_televiosn=findViewById(R.id.idtelevison);
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
        Fetch_Advertisement_Television();
            FetchImage();


    }

    private void Fetch_Advertisement_Television()
    {
        Advertisement_televisiosn.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String television=dataSnapshot.getValue(String.class);
                textView_televiosn.setText(television);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }


    private void FetchImage()
    {

        storage= FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://adcitymart-9095a.appspot.com");
        StorageReference fisrt=reference.child("vehiclead2.jpg");
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


        StorageReference second=reference.child("vehiclead1.jpg");
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

        StorageReference third=reference.child("displayad1.jpg");
        File myfile3=null;
        try {
            myfile3=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile3=myfile3;
        third.getFile(myfile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile3.getAbsolutePath());
                disimage1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(Adverstisement.this, "Fetching ....", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference four=reference.child("displayad2.png");
        File myfile4=null;
        try {
            myfile4=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile4=myfile4;
        four.getFile(myfile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile4.getAbsolutePath());
                disimage2.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference five = reference.child("socialad3.png");
        File myfile5=null;
        try {
            myfile5=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile5=myfile5;
        five.getFile(myfile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile5.getAbsolutePath());
                socialimage1.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });



        StorageReference six = reference.child("socialad2.jpg");
        File myfile6=null;
        try {
            myfile6=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile6=myfile6;
        six.getFile(myfile6).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile6.getAbsolutePath());
                socialimage2.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


        StorageReference seven=reference.child("newsad1.jpg");
        File myfile7=null;
        try
        {
            myfile7=File.createTempFile("images",".jpg");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile7=myfile7;
        seven.getFile(myfile7).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile7.getAbsolutePath());
                news1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference eight=reference.child("eventad1.jpg");
        File myfile8=null;
        try
        {
            myfile8=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile8=myfile8;
        eight.getFile(myfile8).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile8.getAbsolutePath());
                event1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference nine=reference.child("outdoorad1.jpeg");
        File myfile9=null;
        try
        {
            myfile9=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile9=myfile9;
        nine.getFile(myfile9).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile9.getAbsolutePath());
                outdoor1.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference ten=reference.child("outdoorad2.jpg");
        File myfile10=null;
        try
        {
            myfile10=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile10=myfile10;
        ten.getFile(myfile10).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile10.getAbsolutePath());
                outdoor2.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        StorageReference eleven=reference.child("videoad1.jpg");
        File myfile11=null;
        try
        {
            myfile11=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile11=myfile11;
        eleven.getFile(myfile11).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile11.getAbsolutePath());
                video1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference tweleve=reference.child("videoad2.jpg");
        File myfile12=null;
        try
        {
            myfile12=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile12=myfile12;
        tweleve.getFile(myfile12).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile12.getAbsolutePath());
                video2.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });

        StorageReference thirteen=reference.child("eventad2.png");
        File myfile13=null;
        try
        {
            myfile13=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile13=myfile13;
        thirteen.getFile(myfile13).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile13.getAbsolutePath());
                event2.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


        StorageReference fouteen=reference.child("emailad1.jpg");
        File myfile14=null;
        try
        {
            myfile14=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile14=myfile14;
        fouteen.getFile(myfile14).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile14.getAbsolutePath());
                mailimage.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference fifteen=reference.child("emailad2.jpg");
        File myfile15=null;
        try
        {
            myfile15=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile15=myfile15;
        fifteen.getFile(myfile15).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile15.getAbsolutePath());
                mailimag2.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

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
