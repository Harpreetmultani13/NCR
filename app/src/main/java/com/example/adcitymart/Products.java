package com.example.adcitymart;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Products extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.productfrag,container,false);
        view.findViewById(R.id.carddesign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                design(v);

            }
        });
        view.findViewById(R.id.cardAdvertising).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Advertisement(v);
            }
        });
        view.findViewById(R.id.carddesvelopmet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             DevelopmentMethod(v);
            }
        });
        view.findViewById(R.id.cardMarketing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Market(v);
            }
        });
        return view;
    }

    private void Market(View v)
    {
        Intent intent=new Intent(getActivity(),Marketing.class);
        startActivity(intent);
    }

    private void DevelopmentMethod(View v)
    {
        Intent intent=new Intent(getActivity(),Development.class);
        startActivity(intent);
    }

    private void Advertisement(View v)
    {
        Intent intent=new Intent(getActivity(),Adverstisement.class);
        startActivity(intent);
    }

    private void design(View v)
    {
        Intent intent=new Intent(getActivity(),Design.class);
        startActivity(intent);
    }
}
