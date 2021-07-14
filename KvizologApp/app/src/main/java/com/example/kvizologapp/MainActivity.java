package com.example.kvizologapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static String lang;


    private Button btnLogin, btnRegister;
    private EditText tbEmail,tbPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLanguage();
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        lang = shPreferences.getString(SELECTED_LANGUAGE, Locale.getDefault().getLanguage());
        setLocale(MainActivity.this,lang);
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

    private void loginUser() {
        String email = tbEmail.getText().toString();
        String password = tbPassword.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
                    startActivity(new Intent(MainActivity.this, MainScreenAcitivty.class));
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

    public Context setLocale(Context context, String language) {
        lang = language;
        // sacuvamo novi jezik u SharedPreferences
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = shPreferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();

        // sacuvamo promjene u konfiguraciji aplikacije
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        return context;
    }

    private void loadLanguage(){
        String language = readPreference("key_language");
        if("English".equals(language) || "Енглески".equals(language))
            writePreference("SELECTED_LANGUAGE","en");
        if("Serbian".equals(language) || "Српски".equals(language))
            writePreference("SELECTED_LANGUAGE","sr");
    }

    public void writePreference(String key, String value){
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = shPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String readPreference(String key){
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        String value = shPreferences.getString(key, "");
        return value;
    }
}