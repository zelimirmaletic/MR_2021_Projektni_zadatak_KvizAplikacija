package com.example.kvizologapp;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kvizologapp.data.database.KvizologDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizGameActivity extends AppCompatActivity {

    public static int QUESTIONS_PER_CHATEGORY;
    private final static int NUMBER_OF_QUESTIONS_PER_CHATEGORY = 20;
    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;
    public static int HINT_COUNTER = 3;
    public static int POINTS_COUNTER = 0;
    public static int INT_TRENUTNO_PITANJE;
    public static int QUESTION_COUNTER = 0;
    LinearLayout pointsBannerLayout;
    KvizologDatabase databaseInstance;


    static List<Integer> listaPitanja = new ArrayList();

    //Treba pomjeriti poziciju naziva na srpskom sa [7] na [8], dakle za jedno mjesto!


    TextView txvPoints;
    MediaPlayer mpResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        //Instatiate database
        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.quizViewPager);
        txvPoints = findViewById(R.id.txbPoints);
        mpResults = MediaPlayer.create(this,R.raw.results);
        pointsBannerLayout = findViewById(R.id.pointsBannerLayout);
        //Get the number of questions per chategory from PreferenceAPI
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        //String value = shPreferences.getString("key_num_of_questions", "5");
        QUESTIONS_PER_CHATEGORY = 2;//Integer.parseInt(value);


        //Disable scroll on view pager
        viewPager.setOnTouchListener((v, event) -> true);

        //Select random questions from each chategory
        Random rand = new Random();
        int randomNumber=0;
        for(int i=1;i<=4*QUESTIONS_PER_CHATEGORY;i++){
            randomNumber = rand.nextInt(NUMBER_OF_QUESTIONS_PER_CHATEGORY)+1;
            //Make sure all questions are unique
            if(listaPitanja.contains(randomNumber)){
                --i;
                continue;
            }
            if(i<=QUESTIONS_PER_CHATEGORY)
                listaPitanja.add(rand.nextInt(NUMBER_OF_QUESTIONS_PER_CHATEGORY)+1);
            else if(i>QUESTIONS_PER_CHATEGORY && i<=2*QUESTIONS_PER_CHATEGORY)
                listaPitanja.add(NUMBER_OF_QUESTIONS_PER_CHATEGORY + rand.nextInt(NUMBER_OF_QUESTIONS_PER_CHATEGORY)+1);
            else if(i>2*QUESTIONS_PER_CHATEGORY && i<=3*QUESTIONS_PER_CHATEGORY)
                listaPitanja.add(2*NUMBER_OF_QUESTIONS_PER_CHATEGORY + rand.nextInt(NUMBER_OF_QUESTIONS_PER_CHATEGORY)+1);
            else
                listaPitanja.add(3*NUMBER_OF_QUESTIONS_PER_CHATEGORY + rand.nextInt(NUMBER_OF_QUESTIONS_PER_CHATEGORY)+1);
        }
        //Shuffle list
        Collections.shuffle(listaPitanja);
        //Set initial question
        INT_TRENUTNO_PITANJE = listaPitanja.get(0);
        setupViewPager(viewPager);
        databaseInstance = KvizologDatabase.getInstance(this);
        setViewPager(databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE).getTipPitanja());//go to the next question type
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ON DESTROY", Toast.LENGTH_SHORT).show();
        HINT_COUNTER=3;
        POINTS_COUNTER=0;
        QUESTION_COUNTER = 0;
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
        Toast.makeText(this, "Question number"+ INT_TRENUTNO_PITANJE+" \nQuestion type " + fragmentNumber +"\n Question counter "+QUESTION_COUNTER, Toast.LENGTH_LONG).show();
        viewPager.setCurrentItem(fragmentNumber,false);
        viewPager.getAdapter().notifyDataSetChanged();
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

    public static void nextQuestion(){
        ++QUESTION_COUNTER;
        INT_TRENUTNO_PITANJE = listaPitanja.get(QUESTION_COUNTER);
    }

    public KvizologDatabase getDatabaseInstance() {
        return databaseInstance;
    }
}