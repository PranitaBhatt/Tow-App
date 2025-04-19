package com.towapp.towapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class adminregister extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://towapp-1234-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregister);
        final EditText ausername=findViewById(R.id.adminusername);
        final EditText apassword=findViewById(R.id.adminpassword);
        final Button aregisterbtn=findViewById(R.id.aregisterbtn);
        final TextView loginowbtn=findViewById(R.id.Aloginnow);
        aregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameTxt= ausername.getText().toString();
                final String passwordTxt= apassword.getText().toString();

                if(usernameTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(adminregister.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usernameTxt)){
                                Toast.makeText(adminregister.this, "Already Registered", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child("username").setValue(passwordTxt);

                                Toast.makeText(adminregister.this,"user registered succesfull",Toast.LENGTH_SHORT);
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

            }


    }
