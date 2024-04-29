package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Eqvipments extends AppCompatActivity {
    LinearLayout A,B,C,D,E,F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqvipments);
        A=(LinearLayout)findViewById(R.id.rasi);
        B=(LinearLayout)findViewById(R.id.dumbel);
        C=(LinearLayout)findViewById(R.id.bag);
        D=(LinearLayout)findViewById(R.id.glubs);
        E=(LinearLayout)findViewById(R.id.signouts);
        F=(LinearLayout)findViewById(R.id.about);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Eqvipments.this,Rasi.class);
                startActivity(i);}});
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Eqvipments.this,Dumbel.class);
                startActivity(i);}});
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Eqvipments.this,bags.class);
                startActivity(i);}});
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Eqvipments.this,gloves.class);
                startActivity(i);}});
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Eqvipments.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(Eqvipments.this,start.class);
                startActivity(i);
                finish();
            }});
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Eqvipments.this,About.class);
                startActivity(i);}});
    }
}