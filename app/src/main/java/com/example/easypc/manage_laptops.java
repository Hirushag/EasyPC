package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class manage_laptops extends AppCompatActivity {

    Button addLapButton;
    Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_laptops);

        addLapButton = (Button)findViewById(R.id.addSpButton);
        addLapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_laptops.this, insertLaptop.class);
                startActivity(intent);
            }
        });

        viewButton = (Button)findViewById(R.id.viewSpButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_laptops.this, admin_retrieve_laptop.class);
                startActivity(intent);
            }
        });
    }
}