package com.example.kvizologapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainScreenAcitivty extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_acitivty);
        mAuth = FirebaseAuth.getInstance();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


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
        startActivity(new Intent(MainScreenAcitivty.this, MainActivity.class));
    }
}