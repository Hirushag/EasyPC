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
import com.example.easypc.pc;
import com.example.easypc.R;
import com.example.easypc.admin_retrieve_pc;
import com.example.easypc.update_pc;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update_pc extends AppCompatActivity {
    EditText updatem, updatep,updated;
    Button upload,update_upload;
    pc pc;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pc);

        update_upload = (Button)findViewById(R.id.update_upload);
        update_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(update_pc.this, admin_retrieve_pc.class);
                startActivity(intent);
            }
        });

        updatem = findViewById(R.id.update_model);
        updatep = findViewById(R.id.update_price);
        updated = findViewById(R.id.update_desc);
        upload = findViewById(R.id.update_upload);

        this.pc = admin_retrieve_pc.pc.get(0);
        admin_retrieve_pc.pc.remove(0);

        final String model = getIntent().getStringExtra("test");
        final String price = getIntent().getStringExtra("test1");
        final String description = getIntent().getStringExtra("test2");
        updatem.setHint(model);
        updatep.setHint(price);
        updated.setHint(description);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("member2");

                String model = updatem.getText().toString().trim();
                pc.setModel(model);
                String price = updatep.getText().toString().trim();
                pc.setPrice(price);
                String description = updated.getText().toString().trim();
                pc.setDescription(description);

                databaseReference.child(pc.getBrand()).setValue(pc);
                Log.d("auth", "updated");

            }
        });


    }
}