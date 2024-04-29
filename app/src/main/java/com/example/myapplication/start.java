package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {
    Button create;
    Button sigup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        create=(Button)findViewById(R.id.create);
        sigup=(Button)findViewById(R.id.signup);

        create.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i= new Intent(start.this,signup.class);
                startActivity(i);}});



        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(start.this,signin.class);
                startActivity(i);}});
    }
}