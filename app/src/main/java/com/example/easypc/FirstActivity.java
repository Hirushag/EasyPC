package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class FirstActivity extends AppCompatActivity {

    private Button login;
    private Button register;

    private FirebaseAuth auth;
    private FirebaseDatabase fdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();
        FirebaseUser fbu = auth.getCurrentUser();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this , Registration.class));
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this , Login.class));
                finish();

            }

            private void checkEmailVerification(){
                FirebaseUser fbu = auth.getInstance().getCurrentUser();
                Boolean emailflag = fbu.isEmailVerified();

                startActivity(new Intent(FirstActivity.this, ProfileActivity.class));
            }
        });
    }
}