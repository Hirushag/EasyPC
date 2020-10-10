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

public class delete_pc extends AppCompatActivity {
    EditText deletem, deletep,deleted;
    Button dt,delete_pc;


    pc pc;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pc);

        delete_pc = (Button)findViewById(R.id.dt);
        delete_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(delete_pc.this, admin_retrieve_pc.class);
                startActivity(intent);
            }
        });

        dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("member2");

                databaseReference.child(pc.getBrand()).removeValue();

                Log.d("auth", "Deleted!");
            }
        });

    }
}