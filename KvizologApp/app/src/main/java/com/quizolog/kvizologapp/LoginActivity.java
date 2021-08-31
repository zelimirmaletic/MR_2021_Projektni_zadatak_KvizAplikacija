package com.quizolog.kvizologapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText tbEmail,tbPassword;
    private FirebaseAuth mAuth;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tbEmail = findViewById(R.id.editTextEmail);
        tbPassword = findViewById(R.id.editTextPass);
        mAuth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String email = tbEmail.getText().toString();
        String password = tbPassword.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
                    Intent intent = new Intent(LoginActivity.this, MainScreenAcitivty.class);
                    intent.putExtra("username",getUsernameFromEmail());
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(e -> {
                    Toast.makeText(this, getString(R.string.login_invalid_credentials_error_message), Toast.LENGTH_SHORT).show();
                });

            } else {
                tbPassword.setError(getString(R.string.login_empty_field_error_message));
            }
        } else if (email.isEmpty()) {
            tbPassword.setError(getString(R.string.login_empty_field_error_message));
        } else {
            tbPassword.setError(getString(R.string.login_invalid_email_error_message));
        }
    }
    private String getUsernameFromEmail(){
        String[] splited = tbEmail.getText().toString().split("@");
        return splited[0];
    }

}