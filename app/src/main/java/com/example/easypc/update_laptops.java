package com.example.easypc;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.easypc.laptops;
import com.example.easypc.R;
import com.example.easypc.admin_retrieve_laptop;
import com.example.easypc.update_laptops;
import com.example.easypc.laptops;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update_laptops extends AppCompatActivity {
    EditText updatem, updatep,updated;
    Button upload,update_upload;


    laptops laptops;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_laptops);

        update_upload = (Button)findViewById(R.id.update_upload);
        update_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(update_laptops.this, admin_retrieve_laptop.class);
                startActivity(intent);
            }
        });

        updatem = findViewById(R.id.update_model);
        updatep = findViewById(R.id.update_price);
        updated = findViewById(R.id.update_desc);
        upload = findViewById(R.id.update_upload);

        this.laptops = admin_retrieve_laptop.laptops.get(0);
        admin_retrieve_laptop.laptops.remove(0);

        final String model = getIntent().getStringExtra("test");
        final String price = getIntent().getStringExtra("test2");
        final String description = getIntent().getStringExtra("test3");

        updatem.setHint(model);
        updatep.setHint(price);
        updated.setHint(description);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("member");

                String model = updatem.getText().toString().trim();
                laptops.setModel(model);
                String price = updatep.getText().toString().trim();
                laptops.setPrice(price);
                String description = updated.getText().toString().trim();
                laptops.setDescription(description);

                databaseReference.child(laptops.getBrand()).setValue(laptops);
                Log.d("auth", "updated");

            }
        });


    }
}