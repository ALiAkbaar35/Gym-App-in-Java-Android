package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {
   public TextView Name,Email,Gender;
    public MyHolder(@NonNull View itemView) {
        super(itemView);

        Name = itemView.findViewById(R.id.Name);
        Email = itemView.findViewById(R.id.Email);
        Gender = itemView.findViewById(R.id.Gender);


    }
}
