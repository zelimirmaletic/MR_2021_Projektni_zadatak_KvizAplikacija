package com.quizolog.kvizologapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.quizolog.kvizologapp.data.database.KvizologDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainScreenAcitivty extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public static String USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KvizologDatabase database = KvizologDatabase.getInstance(this);
        database.pitanjeDAO().readAll();//call just to instantiate a database
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = shPreferences.getString(MainActivity.SELECTED_LANGUAGE, Locale.getDefault().getLanguage());
        setLocale(MainScreenAcitivty.this,lang);
        setContentView(R.layout.activity_main_screen_acitivty);
        mAuth = FirebaseAuth.getInstance();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        USERNAME = getIntent().getStringExtra("username");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener  navListener = item -> {
        Fragment selectedFragment = null;
        boolean flag = false;
        switch (item.getItemId()){
            case R.id.homeFragment:
                selectedFragment = new HomeFragment();
                break;
            case R.id.settingsFragment:
                selectedFragment = new SettingsFragment();
                break;
            case R.id.statisticsFragment:
                selectedFragment = new StatisticsFragment();
                break;
            case R.id.logout:
                flag=true;
                break;
        }
        if(flag)
            signOut();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,selectedFragment).commit();
        return true;
    };

    private void signOut(){
        mAuth.signOut();
        finish();
        startActivity(new Intent(MainScreenAcitivty.this, MainActivity.class));
    }

    public void changeLanguage(){

        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = shPreferences.getString(MainActivity.SELECTED_LANGUAGE, Locale.getDefault().getLanguage());
        if(lang.equals("en")) {
            setLocale(MainScreenAcitivty.this, "sr");
        }
        else {
            setLocale(MainScreenAcitivty.this, "en");
        }
        // restartujemo activity
        recreate();
    }

    public Context setLocale(Context context, String language) {
        // sacuvamo novi jezik u SharedPreferences
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = shPreferences.edit();
        editor.putString(MainActivity.SELECTED_LANGUAGE, language);
        MainActivity.lang=language;
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

    @Override
    protected void attachBaseContext(Context base) {
        // uzimamo trenutni jezik iz SharedPreferences-a
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(base);
        String lang = shPreferences.getString(MainActivity.SELECTED_LANGUAGE, Locale.getDefault().getLanguage());

        // sacuvamo promjene u konfiguraciji aplikacije
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        base.getResources().updateConfiguration(config,
                base.getResources().getDisplayMetrics());
        super.attachBaseContext(base);
    }

}