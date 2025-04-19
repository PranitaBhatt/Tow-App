package com.towapp.towapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class admindashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);
        ImageButton apbtn=(ImageButton)findViewById(R.id.aimgbtn1);
        ImageButton vsbtn=(ImageButton)findViewById(R.id.aimgbtn2);
        ImageButton pfbtn=(ImageButton)findViewById(R.id.aimgbtn3);
       vsbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(admindashboard.this, scanner.class);
               startActivity(intent);
           }
       });
}
}