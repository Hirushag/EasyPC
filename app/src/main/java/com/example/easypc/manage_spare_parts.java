package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class manage_spare_parts extends AppCompatActivity {

    Button addSpButton;
    Button viewSpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_spare_parts);

        addSpButton = (Button)findViewById(R.id.addSpButton);
        addSpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_spare_parts.this, insertSpareParts.class);
                startActivity(intent);
            }
        });

        viewSpButton = (Button)findViewById(R.id.viewSpButton);
        viewSpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manage_spare_parts.this, admin_retrieve_spare_parts.class);
                startActivity(intent);
            }
        });
    }
}