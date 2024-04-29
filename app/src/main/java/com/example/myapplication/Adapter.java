package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyHolder> {
    ArrayList<Model> list;

    public Adapter(ArrayList<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Model myModel = list.get(position);

        holder.Name.setText(myModel.getName());
        holder.Email.setText(myModel.getEmail());
        holder.Gender.setText(myModel.getGender());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}
