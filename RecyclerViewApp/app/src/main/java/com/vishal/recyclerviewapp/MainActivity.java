package com.vishal.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ContactModal> arrContact = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText etName = dialog.findViewById(R.id.edtName);
                EditText etNumber = dialog.findViewById(R.id.edtNumber);
                Button addBtn = dialog.findViewById(R.id.btnAction);

                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "",number = "";
                        if(!etName.getText().toString().equals("")){
                            name = etName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Name can't be empty!", Toast.LENGTH_SHORT).show();
                        }

                        if(!etNumber.getText().toString().equals("")) {
                            number = etNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Number can't be Empty", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.add(new ContactModal(name,number));

                        adapter.notifyItemInserted(arrContact.size() - 1);

                        recyclerView.scrollToPosition(arrContact.size() - 1);

                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

      //  ContactModal cm = new ContactModal(R.drawable.ic_launcher_background,"ABC","89868785788");

        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ABC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_foreground,"b","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"C","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"AB","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ADBC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_foreground,"ABBC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ABCC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ABC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ABEC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_foreground,"ABC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"O","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"AOABC","886946567890"));
        arrContact.add(new ContactModal(R.drawable.ic_launcher_background,"ABC","886946567890"));


       adapter = new RecyclerContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);

    }
}