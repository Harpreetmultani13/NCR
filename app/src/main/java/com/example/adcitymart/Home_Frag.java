package com.example.adcitymart;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home_Frag extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
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
