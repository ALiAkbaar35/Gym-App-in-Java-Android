package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Trainerlist extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter groupAdapter;
    ArrayList<Model> modelList;

    FirebaseUser firebaseUser;
    DatabaseReference refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainerlist);

        recyclerView=findViewById(R.id.recycler);


        modelList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Trainerlist.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        getList();

    }


    protected void getList(){

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        refer = FirebaseDatabase.getInstance().getReference("users");

        refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelList.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    Model myModel = snapshot1.getValue(Model.class);
                    modelList.add(myModel);
                }

                groupAdapter = new Adapter(modelList);
                recyclerView.setAdapter(groupAdapter);
                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}