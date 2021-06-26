package com.example.kvizologapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainScreenAcitivty extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_acitivty);
        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            signOut();
        });
    }
    private void signOut(){
        mAuth.signOut();
        startActivity(new Intent(MainScreenAcitivty.this, MainActivity.class));
        finish();
    }
}