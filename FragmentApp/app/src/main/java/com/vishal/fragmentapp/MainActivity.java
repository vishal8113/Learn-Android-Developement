package com.vishal.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bFragA,bFragB,bFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFragA = findViewById(R.id.btnFragA);
        bFragB = findViewById(R.id.btnFragB);
        bFragC = findViewById(R.id.btnFragC);


        loadFrag(new ABFragment(),0);

        bFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new ABFragment(),1);
            }
        });

        bFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new BFragment(),1);
            }
        });

        bFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new CFragment(),1);
            }
        });
    }

    public void loadFrag(Fragment fragment,int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == 0)
        {
            ft.add(R.id.container,fragment);
        } else {
            ft.replace(R.id.container,fragment);
            ft.addToBackStack(null);
        }


        ft.commit();
    }

}