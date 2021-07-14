package com.example.kvizologapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kvizologapp.data.model.Pitanje;

public class QuizGameActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;
    public static int HINT_COUNTER = 3;
    public static int POINTS_COUNTER = 0;

    //TEST DATA
    private static Pitanje pitanje1 = new Pitanje(1,"Russia","Moscow","London","Kiev","Vladivostok", "Русија","Москва","Лондон","Кијев","Владивосток", "Moscow","Москва","Red square","Црвени трг","NO_IMAGE");
    private static Pitanje pitanje21 = new Pitanje(2,"","GREECE","","","","","ГРЧКА","","","","","","Birthplace of philosopy...","Родно мјесто философије...","ic_greece");
    //Treba pomjeriti poziciju naziva na srpskom sa [7] na [8], dakle za jedno mjesto!
    public static Pitanje TRENUTNO_PITANJE = pitanje21;

    TextView txvPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.quizViewPager);
        txvPoints = findViewById(R.id.txbPoints);
        setupViewPager(viewPager);
        //Disable scroll on view pager
        viewPager.setOnTouchListener((v, event) -> true);


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

    public void incrementPointsView(){
        txvPoints.setText("POINTS: " + POINTS_COUNTER);
    }

}