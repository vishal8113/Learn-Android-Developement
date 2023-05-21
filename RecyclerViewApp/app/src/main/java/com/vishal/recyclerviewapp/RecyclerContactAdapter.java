package com.vishal.recyclerviewapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModal> arrContact;

    private int lastPosition = -1;

    RecyclerContactAdapter(Context context, ArrayList<ContactModal> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                EditText etName = dialog.findViewById(R.id.edtName);
                EditText etNumber = dialog.findViewById(R.id.edtNumber);
                Button addBtn = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.texTitle);

                addBtn.setText("Update");
                txtTitle.setText("Update Contact");

                etName.setText(arrContact.get(position).name);
                etNumber.setText(arrContact.get(position).number);

                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name = "",number = "";
                        if(!etName.getText().toString().equals("")){
                            name = etName.getText().toString();
                        }else {
                            Toast.makeText(context, "Name can't be empty!", Toast.LENGTH_SHORT).show();
                        }

                        if(!etNumber.getText().toString().equals("")) {
                            number = etNumber.getText().toString();
                        }else {
                            Toast.makeText(context, "Number can't be Empty", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.set(position,new ContactModal(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are You Sure! \uD83D\uDE1F")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"Thanks For Confirming! \uD83D\uDE42",Toast.LENGTH_SHORT).show();
                            }
                        });

                builder.show();


                return true;
            }
        });

        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtNumber;
        ImageView imgContact;
        LinearLayout llRow;

        public ViewHolder(View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgCntct);

            llRow = itemView.findViewById(R.id.llRow);
        }
    }

    private void setAnimation(View viewToAnimate,int position)
    {
        if(position > lastPosition)
        {
            Animation slideIn = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;
        }

    }
}
