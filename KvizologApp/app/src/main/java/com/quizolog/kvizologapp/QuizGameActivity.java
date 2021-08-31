package com.quizolog.kvizologapp;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.quizolog.kvizologapp.data.database.KvizologDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizGameActivity extends AppCompatActivity {

    public static int QUESTIONS_PER_CHATEGORY;
    private final static int NUMBER_OF_QUESTIONS_PER_CHATEGORY = 20;
    private ViewPager viewPager;
    public static int HINT_COUNTER = 3;
    public static int POINTS_COUNTER = 0;
    public static int INT_TRENUTNO_PITANJE;
    public static int QUESTION_COUNTER = 0;
    LinearLayout pointsBannerLayout;
    KvizologDatabase databaseInstance;
    static List<Integer> listaPitanja;
    public static List<Boolean> listaTacnostiOdgovora = new ArrayList();
    public static List<String> listaStringOdgovora = new ArrayList();

    //Treba pomjeriti poziciju naziva na srpskom sa [7] na [8], dakle za jedno mjesto!

    TextView txvPoints;
    MediaPlayer mpResults;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Toast.makeText(this, MainActivity.lang, Toast.LENGTH_SHORT).show();
        MainActivity.setLocale(this,MainActivity.lang);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        //Instatiate database
        databaseInstance = KvizologDatabase.getInstance(this);
        SectionsStatePagerAdapter sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.quizViewPager);
        txvPoints = findViewById(R.id.txbPoints);
        mpResults = MediaPlayer.create(this,R.raw.results);
        pointsBannerLayout = findViewById(R.id.pointsBannerLayout);
        //Get the number of questions per chategory from PreferenceAPI
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        if(savedInstanceState==null) {
            //Clear question arrays
            if (listaStringOdgovora != null)
                listaStringOdgovora.clear();
            if (listaPitanja != null)
                listaPitanja.clear();
            if (listaTacnostiOdgovora != null)
                listaTacnostiOdgovora.clear();
        }
        //Read preference about the number of questions per quiz per category
        String value = shPreferences.getString("key_num_of_questions", "5");
        QUESTIONS_PER_CHATEGORY = Integer.parseInt(value);


        //Disable scroll on view pager
        viewPager.setOnTouchListener((v, event) -> true);

        if(savedInstanceState==null){
            //Select random questions from each chategory
            HINT_COUNTER=3;
            POINTS_COUNTER=0;
            QUESTION_COUNTER = 0;
            listaPitanja = new ArrayList();
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
                    listaPitanja.add(randomNumber);
                else if(i>QUESTIONS_PER_CHATEGORY && i<=2*QUESTIONS_PER_CHATEGORY)
                    listaPitanja.add(NUMBER_OF_QUESTIONS_PER_CHATEGORY + randomNumber);
                else if(i>2*QUESTIONS_PER_CHATEGORY && i<=3*QUESTIONS_PER_CHATEGORY)
                    listaPitanja.add(2*NUMBER_OF_QUESTIONS_PER_CHATEGORY + randomNumber);
                else
                    listaPitanja.add(3*NUMBER_OF_QUESTIONS_PER_CHATEGORY + randomNumber);
            }

            String listaString = "";
            for(int i=0;i<listaPitanja.toArray().length;i++)
                listaString += listaPitanja.get(i)+" ";
            Log.e("PITANJA",listaString);

            //Shuffle list
            Collections.shuffle(listaPitanja);
            //Set initial question
            INT_TRENUTNO_PITANJE = listaPitanja.get(0);
        }
        setupViewPager(viewPager);
        setViewPager(databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE).getTipPitanja());//go to the next question type
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        //Toast.makeText(this, "Question number"+ INT_TRENUTNO_PITANJE+" \nQuestion type " + fragmentNumber +"\n Question counter "+QUESTION_COUNTER, Toast.LENGTH_LONG).show();
        viewPager.setCurrentItem(fragmentNumber,false);
        viewPager.getAdapter().notifyDataSetChanged();
        if(fragmentNumber==4){
            mpResults.start();
            setPointsBannerVisible(false);
        }
    }

    public void incrementPointsView(){
        txvPoints.setText(getResources().getString(R.string.points_text)+ " " + POINTS_COUNTER);
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

    @Override
    public void onBackPressed() {
        HINT_COUNTER=3;
        POINTS_COUNTER=0;
        QUESTION_COUNTER = 0;
        //Clear question arrays
        if (listaStringOdgovora != null)
            listaStringOdgovora.clear();
        if (listaPitanja != null)
            listaPitanja.clear();
        if (listaTacnostiOdgovora != null)
            listaTacnostiOdgovora.clear();
        this.finish();
    }

}