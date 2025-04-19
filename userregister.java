package com.towapp.towapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userregister extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://towapp-1234-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);
        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);
        final EditText vehicleno=findViewById(R.id.vehicleno);
        final Button uregisterbtn=findViewById(R.id.uregisterbtn);
        final TextView loginowbtn=findViewById(R.id.Uloginnow);
       uregisterbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String usernameTxt= username.getText().toString();
               final String passwordTxt= password.getText().toString();
               final String vehiclenoTxt= vehicleno.getText().toString();
               if(usernameTxt.isEmpty() || passwordTxt.isEmpty() || vehiclenoTxt.isEmpty()) {
                   Toast.makeText(userregister.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
               }
               else {
                   databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           if(snapshot.hasChild(vehiclenoTxt)){
                               Toast.makeText(userregister.this, "Already Registered", Toast.LENGTH_SHORT).show();
                           }
                           else{
                               databaseReference.child("users").child(vehiclenoTxt).child("username").setValue(usernameTxt);
                               databaseReference.child("users").child(vehiclenoTxt).child("password").setValue(usernameTxt);
                               Toast.makeText(userregister.this,"user registered succesfull",Toast.LENGTH_SHORT);
                               finish();
                           }
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                       }
                   });

               }

           }
       });




        loginowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}