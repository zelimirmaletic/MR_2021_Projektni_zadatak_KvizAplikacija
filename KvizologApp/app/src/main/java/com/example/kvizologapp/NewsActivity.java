package com.example.kvizologapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    String URL = "https://newsapi.org/v2/everything?q=Bern&from=2021-07-18&sortBy=popularity&apiKey=69dd83012c8a4f5fa9145048e415e48e";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        //69dd83012c8a4f5fa9145048e415e48e   API KEY NEWS API
    }
}