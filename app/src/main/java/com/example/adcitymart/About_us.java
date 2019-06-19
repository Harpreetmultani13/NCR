package com.example.adcitymart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

    TextView textView_who,textView1_mission,textView2_services,textView_choose;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       // getActivity().getActionBar().hide();
       //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        view = inflater.inflate(R.layout.about_us, container, false);
        inti(view);

      mission.addValueEventListener(new ValueEventListener()
      {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
             String mission=dataSnapshot.getValue(String.class);
             textView1_mission.setText(mission);

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
             textView_who.setText(who);
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
              textView_choose.setText(why);

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
              textView2_services.setText(service);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
          }
      });
        return view;
    }

    private void inti(View view)
    {
        textView_who=view.findViewById(R.id.idwho);
        textView1_mission=view.findViewById(R.id.id_mission);
        textView2_services=view.findViewById(R.id.id_services);
        textView_choose=view.findViewById(R.id.id_choose);
    }


}
