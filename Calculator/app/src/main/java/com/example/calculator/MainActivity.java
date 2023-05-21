package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv;
    Button add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        tv = findViewById(R.id.tv);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f,s,a;
                f = Integer.parseInt(et1.getText().toString());
                s = Integer.parseInt(et2.getText().toString());

                a = f + s;
                tv.setText("Result = " + a);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f,s,a;
                f = Integer.parseInt(et1.getText().toString());
                s = Integer.parseInt(et2.getText().toString());

                a = f - s;
                tv.setText("Result  = " + a);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f,s,a;
                f = Integer.parseInt(et1.getText().toString());
                s = Integer.parseInt(et2.getText().toString());

                a = f * s;
                tv.setText("Result = " + a);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float f,s,a;
                f = Float.parseFloat(et1.getText().toString());
                s = Float.parseFloat(et2.getText().toString());

                a = f / s;
                tv.setText("Result = " + a);
            }
        });
    }
}