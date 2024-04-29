package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashScreen();

    }


    public void splashScreen(){
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent intent = new Intent(MainActivity.this,start.class);
                    startActivity(intent);
                }catch (Exception e){

                }
            }};
        thread.start();

    }
}