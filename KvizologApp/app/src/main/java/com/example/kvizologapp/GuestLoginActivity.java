package com.example.kvizologapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class GuestLoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextInputLayout txbUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        btnLogin = findViewById(R.id.btnLogin);
        txbUsername = findViewById(R.id.tbUsername);
        btnLogin.setOnClickListener(v -> {
            if(!txbUsername.getEditText().getText().toString().isEmpty()){
                Intent intent = new Intent(GuestLoginActivity.this, MainScreenAcitivty.class);
                intent.putExtra("username",txbUsername.getEditText().getText().toString());
                startActivity(intent);
                finish();
            }else{
                txbUsername.setError(getString(R.string.login_empty_field_error_message));
            }
        });
    }
}