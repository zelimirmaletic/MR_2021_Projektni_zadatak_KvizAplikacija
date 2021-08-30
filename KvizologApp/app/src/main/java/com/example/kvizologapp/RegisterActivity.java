package com.example.kvizologapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {

    private EditText tbEmail, tbPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tbEmail = findViewById(R.id.editTextEmail);
        tbPassword = findViewById(R.id.editTextPass);
        btnRegister = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void onClickRegisterButton(View view){

    }

    private void createUser(){
        String email = tbEmail.getText().toString();
        String password = tbPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
             if(!password.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                    //Insert a toast message of success
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(RegisterActivity.this, getString(R.string.login_invalid_credentials_error_message), Toast.LENGTH_SHORT).show();
                    }
                });
             }else{
                 tbPassword.setError(getString(R.string.login_empty_field_error_message));
             }
        }else if (email.isEmpty()){
            tbPassword.setError(getString(R.string.login_empty_field_error_message));
        }else{
            tbPassword.setError(getString(R.string.login_invalid_email_error_message));
        }
    }
}