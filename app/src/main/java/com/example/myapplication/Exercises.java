package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Exercises extends AppCompatActivity {
     Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        home=(Button)findViewById(R.id.btnexercise);


        home.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i= new Intent(Exercises.this,Home.class);
                startActivity(i);}});
    }
}