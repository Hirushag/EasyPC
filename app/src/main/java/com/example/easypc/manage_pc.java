package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class manage_pc extends AppCompatActivity {

    Button addPcButton;
    Button viewPcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_pc);

        addPcButton = (Button)findViewById(R.id.addSpButton);
        addPcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_pc.this, insertPc.class);
                startActivity(intent);
            }
        });

        viewPcButton = (Button)findViewById(R.id.viewSpButton);
        viewPcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_pc.this, admin_retrieve_pc.class);
                startActivity(intent);
            }
        });
    }
}