package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity {

    private TextView proName,proAddress,proEmail,proContact;
    private Button proEdit,home;

    private FirebaseAuth auth;
    private FirebaseDatabase fdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);


        proName = findViewById(R.id.profilename);
        proAddress = findViewById(R.id.profileaddress);
        proEmail = findViewById(R.id.profileemail);
        proContact = findViewById(R.id.profilecontact);
        proEdit = findViewById(R.id.profileedit);
        home = findViewById(R.id.home);

        auth = FirebaseAuth.getInstance();
        fdb = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = fdb.getReference(auth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                proName.setText("Name: " + userProfile.getUserName());
                proAddress.setText("Address: " + userProfile.getUserAddress());
                proEmail.setText("Email: " + userProfile.getUserEmail());
                proContact.setText("Contact: " + userProfile.getUserContact());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this , databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        proEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,UpdateProfile.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });

    }
}