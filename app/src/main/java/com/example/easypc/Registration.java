package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    private EditText name, password, address, email, contact;
    private Button register;
    String Name, Password, Address, Email, Contact;

    private FirebaseAuth auth;
    private FirebaseDatabase fdb;
    private DatabaseReference dbr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        auth = FirebaseAuth.getInstance();
        fdb = FirebaseDatabase.getInstance();
        dbr = FirebaseDatabase.getInstance().getReference("UserProfile");



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    final String Email = email.getText().toString().trim();
                    final String Password = password.getText().toString().trim();

                    auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendUserData();
                                //auth.signOut();
                                Toast.makeText(Registration.this, "Registering user successful", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Registration.this, FirstActivity.class));

                            } else {
                                Toast.makeText(Registration.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        private void sendUserData() {
                            FirebaseDatabase fdb = FirebaseDatabase.getInstance();
                            DatabaseReference dbr = fdb.getReference(auth.getUid());
                            UserProfile userProfile = new UserProfile(Name,Address,Email,Contact);
                            dbr.setValue(userProfile);

                        }
                    });

                }
            }

            private boolean validate() {
                Boolean result = false;

                Name = name.getText().toString();
                Password = password.getText().toString();
                Email = email.getText().toString();
                Address = address.getText().toString();
                Contact = contact.getText().toString();


                if (Name.isEmpty() || Password.isEmpty() || Email.isEmpty() || Address.isEmpty() || Contact.isEmpty()) {
                    Toast.makeText(Registration.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                }else if (Password.length() < 6) {
                    Toast.makeText(Registration.this, "Password too short!", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = true;
                }
                return result;
            }
            });


        }

    private void setupUIViews() {
        name = (EditText) findViewById(R.id.entername);
        password = (EditText) findViewById(R.id.enterpassword);
        address = (EditText) findViewById(R.id.enteraddress);
        email = (EditText) findViewById(R.id.enteremail);
        contact = (EditText) findViewById(R.id.entercontact);
        register = (Button) findViewById(R.id.register);
    }


    }

