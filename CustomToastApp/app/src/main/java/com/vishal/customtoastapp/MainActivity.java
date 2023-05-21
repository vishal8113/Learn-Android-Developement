package com.vishal.customtoastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());

                View v = getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewId));

                toast.setView(v);

                TextView txtMsg = v.findViewById(R.id.txtMsg);
                txtMsg.setText("Message Sent Successfully!");

                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

                toast.show();

                Log.d("Test","Test Log");

                String TAG = "Message";
                Log.d(TAG,"Message was displayed");


            }
        });


    }


}