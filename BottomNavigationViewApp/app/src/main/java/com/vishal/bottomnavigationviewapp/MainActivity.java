package com.vishal.bottomnavigationviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bt_nav);
        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home){
                    loadFrag(new AFragment(),0);
                } else if(id == R.id.nav_search){
                    loadFrag(new BFragment(),1);
                } else if(id == R.id.nav_utilities)
                {
                    loadFrag(new CFragment(),1);
                } else if(id == R.id.nav_contacts)
                {
                    loadFrag(new DFragment(),1);
                } else {
                    loadFrag(new ProfileFragment(),1);
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    public void loadFrag(Fragment fragment,int flag)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag == 0)
        {
            fragmentTransaction.add(R.id.container,fragment);
        } else {
            fragmentTransaction.replace(R.id.container,fragment);
        }

        fragmentTransaction.commit();
    }
}
