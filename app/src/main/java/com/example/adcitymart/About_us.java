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
   // FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference myRef = database.getReference("https://adcitymart-9095a.firebaseio.com/");

    TextView textView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       // init(view);

        view = inflater.inflate(R.layout.about_us, container, false);
       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
            ShowData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();

            }
        });*/
        return view;
    }

   /* private void ShowData(DataSnapshot dataSnapshot)
    {
        String value = dataSnapshot.getValue(String.class);
        Toast.makeText(getActivity(), "U enter"+value, Toast.LENGTH_SHORT).show();
    }*/
}
