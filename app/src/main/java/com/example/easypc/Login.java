package com.example.easypc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    private FirebaseAuth auth;
    private FirebaseUser fbu;
    private DatabaseReference dbr;
    private ProgressDialog pd;
    private FirebaseDatabase fbd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void CheckLogin(View view) {

        username = findViewById(R.id.enteremail);
        password = findViewById(R.id.enterpassword);
        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();
        fbd = FirebaseDatabase.getInstance();
        pd = new ProgressDialog(this);
        FirebaseUser fbu = auth.getCurrentUser();

        if (fbu != null){
             finish();
             startActivity(new Intent(Login.this,ProfileActivity.class));
        }


        try {
            if (TextUtils.isEmpty(username.getText().toString()))
                Toast.makeText(this, "Please enter the Username", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(password.getText().toString()))
                Toast.makeText(this, "Please enter the Password", Toast.LENGTH_SHORT).show();
            else {

                dbr = FirebaseDatabase.getInstance().getReference().child("User").child("Customer");
                DatabaseReference dbrAdmin = FirebaseDatabase.getInstance().getReference().child("User").child("Admin");
                DatabaseReference dbrPC = FirebaseDatabase.getInstance().getReference().child("User").child("PC");
                final DatabaseReference dbrLap = FirebaseDatabase.getInstance().getReference().child("User").child("Laptop");
                DatabaseReference dbrSpare = FirebaseDatabase.getInstance().getReference().child("User").child("SpareParts");


                dbr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String un = null, pwd = null;
                        if (dataSnapshot.hasChildren()) {
                            pwd = dataSnapshot.child("password").getValue().toString();
                            un = dataSnapshot.child("username").getValue().toString();
                            if (pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())) {
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                                startActivity(intent);

                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });


                dbrAdmin.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String un = null, pwd = null;
                        if (dataSnapshot.hasChildren()) {
                            pwd = dataSnapshot.child("password").getValue().toString();
                            un = dataSnapshot.child("username").getValue().toString();
                            if (pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())) {
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Admin.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                dbrPC.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String un = null, pwd = null;
                        if (dataSnapshot.hasChildren()) {
                            pwd = dataSnapshot.child("password").getValue().toString();
                            un = dataSnapshot.child("username").getValue().toString();
                            if (pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())) {
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Admin.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                dbrLap.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String un = null, pwd = null;
                        if (dataSnapshot.hasChildren()) {
                            pwd = dataSnapshot.child("password").getValue().toString();
                            un = dataSnapshot.child("username").getValue().toString();
                            if (pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())) {
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Admin.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                dbrSpare.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String un = null, pwd = null;
                        if (dataSnapshot.hasChildren()) {
                            pwd = dataSnapshot.child("password").getValue().toString();
                            un = dataSnapshot.child("username").getValue().toString();
                            if (pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())) {
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Admin.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }


        } catch (Exception e) {
            e.getMessage();
        }
    }
}

