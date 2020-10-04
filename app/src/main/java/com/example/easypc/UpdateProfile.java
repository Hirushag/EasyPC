package com.example.easypc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {

    private EditText editName,editAddress,editEmail,editContact;
    private Button Save;

    private FirebaseAuth auth;
    private FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        editName = findViewById(R.id.editname);
        editAddress = findViewById(R.id.editaddress);
        editEmail = findViewById(R.id.editemail);
        editContact = findViewById(R.id.editcontact);
        Save = findViewById(R.id.save);

        auth = FirebaseAuth.getInstance();
        fdb = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = fdb.getReference(auth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                editName.setText(userProfile.getUserName());
                editAddress.setText(userProfile.getUserAddress());
                editEmail.setText(userProfile.getUserEmail());
                editContact.setText(userProfile.getUserContact());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateProfile.this , databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String address = editAddress.getText().toString();
                String email = editEmail.getText().toString();
                String contact = editContact.getText().toString();

                UserProfile userProfile = new UserProfile(name,address,email,contact);

                databaseReference.setValue(userProfile);
                Toast.makeText(UpdateProfile.this, "Saving successful", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
    }
}