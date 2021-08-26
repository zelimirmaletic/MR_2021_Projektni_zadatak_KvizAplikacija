package com.example.kvizologapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kvizologapp.data.database.KvizologDatabase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static String lang;
    
    private Button btnLogin, btnRegister, btnGuestLogin;
    private EditText tbEmail,tbPassword;
    FirebaseAuth mAuth;
    KvizologDatabase databaseInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KvizologDatabase databaseInstance = KvizologDatabase.getInstance(this);
        loadLanguage();
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        lang = shPreferences.getString(SELECTED_LANGUAGE, Locale.getDefault().getLanguage());
        setLocale(MainActivity.this,lang);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        tbEmail = findViewById(R.id.editTextEmail);
        tbPassword = findViewById(R.id.editTextPass);
        btnGuestLogin = findViewById(R.id.btnGuestLogin);
        mAuth = FirebaseAuth.getInstance();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        /*
        KvizologDatabase databaseInstance = KvizologDatabase.getInstance(this);
        if(databaseInstance.pitanjeDAO().getById(1)==null)
            Toast.makeText(this, "JEBENI NULL", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, databaseInstance.pitanjeDAO().getById(1).getTekstPitanjaEngleski(), Toast.LENGTH_SHORT).show();
        */

        //Using labmda
        btnRegister.setOnClickListener(v -> {
            if(isConnected()){
                Intent intet = new Intent(this, RegisterActivity.class);
                startActivity(intet);
            }else{
                Toast.makeText(this, getString(R.string.no_internet_available_message_login), Toast.LENGTH_LONG).show();
            }
        });
        btnLogin.setOnClickListener(v -> {
            if(isConnected()){
                Intent intet = new Intent(this, LoginActivity.class);
                startActivity(intet);
            }else{
                Toast.makeText(this, getString(R.string.no_internet_available_message_login), Toast.LENGTH_LONG).show();
            }
        });
        btnGuestLogin.setOnClickListener(v -> {
            Intent intet = new Intent(this, GuestLoginActivity.class);
            startActivity(intet);
        });
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

    public static String getLang() {
        return lang;
    }
    
    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void setLocale(Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}