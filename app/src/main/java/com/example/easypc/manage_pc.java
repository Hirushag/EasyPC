package com.example.easypc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class manage_pc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_pc);


    }

    public void onClick(View view) {

        Intent i = new Intent(this,Manage_pc_back.class);
        startActivity(i);
    }

    public void add(View view) {
        Intent i = new Intent(this,insert_pc_parts.class);
        startActivity(i);
    }

}