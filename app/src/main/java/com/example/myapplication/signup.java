package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    String[] quantity = {"Male","Female","Other"};
    Button btn_signup;
    TextView btn_signin;
    EditText email,username,pw,id,number;
    Spinner spinner;
    FirebaseAuth auth;
    DatabaseReference refer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.amet3);
        username = findViewById(R.id.amet1);
        pw = findViewById(R.id.amet6);
        number = findViewById(R.id.amet2);
        id= findViewById(R.id.amet4);
        spinner = findViewById(R.id.radioGroup);
        btn_signup =findViewById(R.id.abc);
        btn_signin =findViewById(R.id.abcd);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,quantity);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        //Initilize object
        auth = FirebaseAuth.getInstance();

        //TO GO BACK
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup.this, signin.class);
                startActivity(i);
                finish();
            }
        });

        //Register USER IN FIREBASE
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //GET DATA TO STRING TYPE
                String em = email.getText().toString();
                String passw = pw.getText().toString();

                //CREATE USER WITH EMIAL AND PW
                Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword(em, passw)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = auth.getCurrentUser();

                                    String userid = user.getUid();
                                    String Name= username.getText().toString();
                                    String Email= email.getText().toString();
                                    String Number= number.getText().toString();
                                    String password = pw.getText().toString();
                                    String ID= id.getText().toString();
                                    String gen = spinner.getSelectedItem().toString();

                                    refer = FirebaseDatabase.getInstance().getReference("users").child(userid);
                                    HashMap<String,String> hashMap = new HashMap<>();
                                    hashMap.put("id",userid);
                                    hashMap.put("Name",Name);
                                    hashMap.put("Email",Email);
                                    hashMap.put("Number",Number);
                                    hashMap.put("Password",password);
                                    hashMap.put("Id_Card",ID);
                                    hashMap.put("Gender",gen);


                                    refer.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                            ;


                                                Toast.makeText(signup.this, "Sucessfully Signed Up", Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(signup.this, Home.class);
                                                startActivity(i);
                                                finish();



                                            }
                                        }
                                    });

                                } else {
                                    Toast.makeText(signup.this, "some error occured", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}