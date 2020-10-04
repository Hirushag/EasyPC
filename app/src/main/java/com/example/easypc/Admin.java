package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    Button managepc,managelap,managesp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        managepc = findViewById(R.id.managepc);
        managelap = findViewById(R.id.managelap);
        managesp = findViewById(R.id.managespare);

        managepc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this,manage_pc.class));
            }
        });

        managelap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this,manage_laptops.class));
            }
        });

        managesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this,manage_spare_parts.class));
            }
        });

    }
}