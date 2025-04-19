package com.towapp.towapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        final EditText username=findViewById(R.id.ued1);
        final EditText password=findViewById(R.id.ued2);
        final Button uloginbtn=findViewById(R.id.btnulogin);
        final TextView registernowbtn=findViewById(R.id.Uregisternowbtn);
        uloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernametxt=username.getText().toString();
                final String passwordtxt=password.getText().toString();
                if(usernametxt.isEmpty() || passwordtxt.isEmpty()){
                    Toast.makeText(userlogin.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(userlogin.this, userdashboard.class);
                    startActivity(intent);


                }
            }
        });
        registernowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userlogin.this, userregister.class));
            }
        });
    }
}