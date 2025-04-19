package com.towapp.towapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        final EditText ausername=findViewById(R.id.aed1);
        final EditText apassword=findViewById(R.id.aed2);
        final Button aloginbtn=findViewById(R.id.btnalogin);
        final TextView registernowbtn=findViewById(R.id.Aregisternowbtn);
        aloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernametxt=ausername.getText().toString();
                final String passwordtxt=apassword.getText().toString();
                if(usernametxt.isEmpty() || passwordtxt.isEmpty()){
                    Toast.makeText(adminlogin.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(adminlogin.this, admindashboard.class);
                    startActivity(intent);

                }
            }
        });
        registernowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminlogin.this, userregister.class));
            }
        });
    }
}
