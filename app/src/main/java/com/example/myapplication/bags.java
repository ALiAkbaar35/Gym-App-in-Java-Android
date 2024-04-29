package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class bags extends AppCompatActivity {
    String[] quantities = {"Small","Medium","Large"};
    Button conf;
    TextView cen;
    EditText email,username,Add,ite,number;
    Spinner siz;
    FirebaseAuth auth;
    DatabaseReference refer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        
        email = findViewById(R.id.usemail);
        username = findViewById(R.id.usname);
        Add = findViewById(R.id.add);
        number = findViewById(R.id.contact);
        ite= findViewById(R.id.items);
        siz = findViewById(R.id.size);
        conf =findViewById(R.id.confrim);
        cen =findViewById(R.id.cencel);
        
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,quantities);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        siz.setAdapter(arrayAdapter);

        auth = FirebaseAuth.getInstance();

     
        cen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bags.this,Eqvipments.class);
                startActivity(i);
                finish();
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser user = auth.getCurrentUser();
                String userid = user.getUid();
                String Name= username.getText().toString();
                String Email= email.getText().toString();
                String Number= number.getText().toString();
                String Address = Add.getText().toString();
                String it= ite.getText().toString();
                String type = siz.getSelectedItem().toString();

                AlertDialog.Builder builder1 = new AlertDialog.Builder(bags.this);
                builder1.setTitle("Conformation");
                builder1.setMessage(""+

                        "\n\n" +      "ID: "+userid+
                        "\n\n" +      "User Name: "+Name+
                        "\n\n" +      "Email: "+Email+
                        "\n\n" +      "Phone Number: "+Number+
                        "\n\n" +      "Postal Address: "+Address+
                        "\n\n" +      "Num oF Items: "+it+
                        "\n\n" +      "Size: "+type );
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                refer = FirebaseDatabase.getInstance().getReference("bags_orders").child(userid);
                                HashMap<String,String> hashMap = new HashMap<>();
                                hashMap.put("id",userid);
                                hashMap.put("username",Name);
                                hashMap.put("Email",Email);
                                hashMap.put("Number",Number);
                                hashMap.put("Address",Address);
                                hashMap.put("NUm of Items",it);
                                hashMap.put("Size",type);


                                refer.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {

                                            Toast.makeText( bags.this, "Order Is Placed Successfully,Within Some Days That Will Received.", Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent( bags.this, Eqvipments.class);
                                            startActivity(i);
                                            finish();



                                        }
                                    }
                                });

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(bags.this, "Order Cencel", Toast.LENGTH_SHORT).show();

                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

    }

}

