package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    LinearLayout A,B,C,D,E,G;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        A=(LinearLayout) findViewById(R.id.trainer);
        B=(LinearLayout)findViewById(R.id.diet);
        C=(LinearLayout)findViewById(R.id.activity);
        D=(LinearLayout)findViewById(R.id.eqvipment);
        E=(LinearLayout)findViewById(R.id.about);
        G=(LinearLayout)findViewById(R.id.signouts);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home.this,Trainerlist.class);
                startActivity(i);}});
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home.this,Dietplan.class);
                startActivity(i);}});
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home.this,Exercises.class);
                startActivity(i);}});
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home.this,Eqvipments.class);
                startActivity(i);}});
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home.this,About.class);
                startActivity(i);}});

        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Home.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(Home.this,start.class);
                startActivity(i);
                finish();
            }});

    }
}