package com.example.kvizologapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kvizologapp.data.model.Pitanje;

public class QuizGameActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;
    public static int HINT_COUNTER = 3;
    public static int POINTS_COUNTER = 0;
    LinearLayout pointsBannerLayout;

    //TEST DATA
    private static Pitanje pitanje1 = new Pitanje(1,"Russia","Moscow","London","Kiev","Vladivostok", "Русија","Москва","Лондон","Кијев","Владивосток", "Moscow","Москва","Red square","Црвени трг","NO_IMAGE");
    private static Pitanje pitanje21 = new Pitanje(2,"","GREECE","","","","","ГРЧКА","","","","","","Birthplace of philosopy...","Родно мјесто философије...","ic_greece");
    private static Pitanje pitanje42 = new Pitanje(3, "Germany","Russia","Austria","Poland","Switzerland","Њемачка","Русија","Аустрија","Пољаска","Швајцарска","Austria Switzerland","Аустрија Швајцарска","German speaking countries.","Државе њемачког говорног подручја.","NO_IMAGE");
    private static Pitanje pitanje80 = new Pitanje(4,"Church of Christ The Saviour","Bosnia and Herzegovina","Serbia","Montenegro","North Macedonia","Храм Христа Спаситеља","Босна и Херцеговина","Србија","Црна Гора","Сјеверна Македонија","Bosnia and Herzegovina","Босна и Херцеговина","Sarajevo is a capital city.","Сарајево је главни град.","christ_the_saviour");

    //Treba pomjeriti poziciju naziva na srpskom sa [7] na [8], dakle za jedno mjesto!
    public static Pitanje TRENUTNO_PITANJE = pitanje1;

    TextView txvPoints;
    MediaPlayer mpResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.quizViewPager);
        txvPoints = findViewById(R.id.txbPoints);
        mpResults = MediaPlayer.create(this,R.raw.results);
        pointsBannerLayout = findViewById(R.id.pointsBannerLayout);
        setupViewPager(viewPager);
        //Disable scroll on view pager
        viewPager.setOnTouchListener((v, event) -> true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        HINT_COUNTER=3;
        POINTS_COUNTER=0;
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
        if(fragmentNumber==4){
            mpResults.start();
            setPointsBannerVisible(false);
        }

    }

    public void incrementPointsView(){
        txvPoints.setText("POINTS: " + POINTS_COUNTER);
    }

    public void setPointsBannerVisible(boolean visible){
        if(!visible)
            pointsBannerLayout.setVisibility(View.INVISIBLE);
        else
            pointsBannerLayout.setVisibility(View.VISIBLE);
    }
}