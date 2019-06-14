package com.example.adcitymart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class About_us extends Fragment
{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
   DatabaseReference mission = database.getReference("About_Us/Our_Mission");
   DatabaseReference who=database.getReference("About_Us/Who_We_Are");
   DatabaseReference why=database.getReference("About_Us/Why_Choose_Us");
   DatabaseReference services=database.getReference("About_Us/Services");

    TextView textView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {


        view = inflater.inflate(R.layout.about_us, container, false);
      mission.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
             String mission=dataSnapshot.getValue(String.class);

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
          }
      });
      who.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
             String who=dataSnapshot.getValue(String.class);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();

          }
      });
      why.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String why=dataSnapshot.getValue(String.class);

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
          }
      });
      services.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
             String service=dataSnapshot.getValue(String.class);
              Toast.makeText(getActivity(), "OUR SERVICES  "+service, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
          }
      });
        return view;
    }



}
