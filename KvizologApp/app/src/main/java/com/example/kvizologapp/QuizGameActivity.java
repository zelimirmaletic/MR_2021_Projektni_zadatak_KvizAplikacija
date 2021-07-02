package com.example.kvizologapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class QuizGameActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.quizViewPager);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TipPitanjaGlavniGradFragment(), "Capital city");
        adapter.addFragment(new TipPitanjaZastavaFragment(),"Flag");
        adapter.addFragment(new TipPitanjaSusjednaDrzavaFragment(),"Neighbour countries");
        adapter.addFragment(new TipPitanjaZnamenitostFragment(),"Heritage");
        adapter.addFragment(new QuizResultsFragment(),"Results");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }
}