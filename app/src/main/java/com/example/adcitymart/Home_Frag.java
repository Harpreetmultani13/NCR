package com.example.adcitymart;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Home_Frag extends Fragment
{

FirebaseStorage storage;
StorageReference reference;


    View view;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.home_fragment,container,false);
        ImageInit();
        Init(view);

        view.findViewById(R.id.cardblog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               blog(v);

            }
        });



        view.findViewById(R.id.cardcareer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             career(v);
            }
        });


        view.findViewById(R.id.cardfollow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                follow(v);
            }
        });
        view.findViewById(R.id.cardintern).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intern(v);

            }
        });
        return view;
    }

    private void ImageInit()
    {
         storage= FirebaseStorage.getInstance();
         reference=storage.getReferenceFromUrl("gs://adcitymart-9095a.appspot.com");
         StorageReference fisrt=reference.child("ajio.png");
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
                Toast.makeText(getActivity(), "NO Internet", Toast.LENGTH_SHORT).show();

            }
        });
        StorageReference second=reference.child("aliexpress.png");
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
                Bitmap bitmap=BitmapFactory.decodeFile(finalfilefile2.getAbsolutePath());
                imageView2.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference third=reference.child("axisbank.png");
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
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile3.getAbsolutePath());
                imageView3.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference fourth=reference.child("bob.png");
        File myfile4=null;
        try {
            myfile4=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {

            e.printStackTrace();
        }
      final File finalfile4=myfile4;
        fourth.getFile(myfile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile4.getAbsolutePath());
                imageView4.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference fifth=reference.child("car24.png");
        File myfile5=null;
        try {
            myfile5=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile5=myfile5;
        fifth.getFile(myfile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile5.getAbsolutePath());
                imageView5.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference sixth=reference.child("crossword.png");
        File myfile6=null;
        try {
            myfile6=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile6=myfile6;
        sixth.getFile(myfile6).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile6.getAbsolutePath());
                imageView6.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference seven=reference.child("ing.png");
        File myfile7=null;
        try {
            myfile7=File.createTempFile("images",".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final File finalfile7=myfile7;
        seven.getFile(myfile7).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile7.getAbsolutePath());
                imageView7.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference eight=reference.child("idbi.png");
        File myfile8=null;
        try {
            myfile8=File.createTempFile("images",".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final File finalfile8=myfile8;
        eight.getFile(myfile8).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile8.getAbsolutePath());
                imageView8.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference nine=reference.child("axisbank.png");
        File myfile9=null;
        try {
            myfile9=File.createTempFile("images",".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final   File finalfile9=myfile9;
        nine.getFile(myfile9).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finalfile9.getAbsolutePath());
                imageView9.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });
        StorageReference ten=reference.child("icici.png");
        File myfile10=null;
        try
        {
            myfile10=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finallyfile10=myfile10;
        ten.getFile(myfile10).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap=BitmapFactory.decodeFile(finallyfile10.getAbsolutePath());
                imageView10.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getActivity(), "NO Intenet", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void Init(View view)
    {
        imageView1=view.findViewById(R.id.image1);
        imageView2=view.findViewById(R.id.image2);
        imageView3=view.findViewById(R.id.image3);
        imageView4=view.findViewById(R.id.image4);
        imageView5=view.findViewById(R.id.image5);
        imageView6=view.findViewById(R.id.image6);
        imageView7=view.findViewById(R.id.image7);
        imageView8=view.findViewById(R.id.image8);
        imageView9=view.findViewById(R.id.image9);
        imageView10=view.findViewById(R.id.image10);
    }

    private void follow(View v)
    {
        Intent intent=new Intent(getActivity(),Follow_Us.class);
        startActivity(intent);
    }

    private void Intern(View v)
    {
        Intent intent=new Intent(getActivity(),Intership.class);
        startActivity(intent);
    }

    private void career(View v)
    {
        Intent intent=new Intent(getActivity(),Careers.class);
        startActivity(intent);
    }

    private void blog(View v)
    {
        Intent intent=new Intent(getActivity(),Blog.class);
        startActivity(intent);
    }

}
//done