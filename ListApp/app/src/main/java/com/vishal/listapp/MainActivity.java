package com.vishal.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Spinner spinner;
    AutoCompleteTextView ac;

    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();

    ArrayList<String> arrCities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        ac = findViewById(R.id.autoComp);


        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");
        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");
        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");
        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");
        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");
        arrNames.add("Vishal");
        arrNames.add("kritika");
        arrNames.add("Mahika");
        arrNames.add("Rajan");

        arrCities.add("Haridwar");
        arrCities.add("Dehradun");
        arrCities.add("Delhi");
        arrCities.add("Lucknow");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "First Was Clicked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        arrIds.add("One");
        arrIds.add("Two");
        arrIds.add("Three");
        arrIds.add("Four");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);


        ArrayAdapter<String> autoAdaptet = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrCities);
        ac.setAdapter(autoAdaptet);
        ac.setThreshold(3);


    }
}