package com.example.kvizologapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText tbEmail,tbPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        tbEmail = findViewById(R.id.editTextEmail);
        tbPassword = findViewById(R.id.editTextPass);
        mAuth = FirebaseAuth.getInstance();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Using labmda
        btnRegister.setOnClickListener(v -> {
            Intent intet = new Intent(this, RegisterActivity.class);
            startActivity(intet);
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String email = tbEmail.getText().toString();
        String password = tbPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!password.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
                    Toast.makeText(this, "Успјешно пријављен!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainScreenAcitivty.class));
                    finish();
                }).addOnFailureListener(e -> {
                    Toast.makeText(this, "Грешка при пријављивању!", Toast.LENGTH_SHORT).show();
                });

            }else{
                tbPassword.setError("Празна поља нису дозвољена!");//Prevesti i na egleski!!
            }
        }else if (email.isEmpty()){
            tbPassword.setError("Празна поља нису дозвољена!");//Prevesti i na egleski!!
        }else{
            tbPassword.setError("Молимо Вас да унесете исправан имејл !");//Prevesti i na egleski!!
        }
    }

}