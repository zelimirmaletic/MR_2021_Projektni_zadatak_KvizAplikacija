package com.example.kvizologapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kvizologapp.data.database.KvizologDatabase;
import com.example.kvizologapp.data.model.Pitanje;

public class TipPitanjaZnamenitostFragment extends Fragment {

    Button btnNextQuestion, btnHint;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    //Sound efects
    MediaPlayer mpCorrect, mpWrong, mpHint;
    ImageView imgHeritage, imgView;
    TextView txvHeritageName,txvCornectnessMessage;
    Pitanje TRENUTNO_PITANJE;



    public TipPitanjaZnamenitostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tip_pitanja_znamenitost, container, false);
        //Get a reference to database
        KvizologDatabase databaseInstance = ((QuizGameActivity)getActivity()).getDatabaseInstance();
        TRENUTNO_PITANJE = databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE);
        //Initialize views
        btnNextQuestion = view.findViewById(R.id.btnNextQuestion);
        btnHint = (Button) view.findViewById(R.id.btnHint);
        btnAnswer1 = (Button) view.findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) view.findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) view.findViewById(R.id.btnAnswer3);
        btnAnswer4 = (Button) view.findViewById(R.id.btnAnswer4);
        txvHeritageName = (TextView)view.findViewById(R.id.txbHeritageName);
        txvCornectnessMessage = (TextView) view.findViewById(R.id.txvCorectnessMessage);
        imgHeritage = (ImageView) view.findViewById(R.id.imgHeritage);
        imgView = (ImageView)view.findViewById(R.id.imageView);
        mpCorrect = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.correct);
        mpWrong = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.wrong);
        mpHint = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.hint);
        //Hide hint if it is already used 3 times
        if(QuizGameActivity.HINT_COUNTER == 0)
            btnHint.setVisibility(View.GONE);
        //Show question data
        imgHeritage.setImageResource(getResources().getIdentifier(TRENUTNO_PITANJE.getSlika(),"drawable",((QuizGameActivity)getActivity()).getPackageName()));
        if("en".equals(MainActivity.lang)){
            txvHeritageName.setText(TRENUTNO_PITANJE.getTekstPitanjaEngleski());
            btnAnswer1.setText(TRENUTNO_PITANJE.getOdgovorBr1Engleski());
            btnAnswer2.setText(TRENUTNO_PITANJE.getOdgovorBr2Engleski());
            btnAnswer3.setText(TRENUTNO_PITANJE.getOdgovorBr3Engleski());
            btnAnswer4.setText(TRENUTNO_PITANJE.getOdgovorBr4Engleski());
        }else {
            txvHeritageName.setText(TRENUTNO_PITANJE.getTekstPitanjaSrpski());
            btnAnswer1.setText(TRENUTNO_PITANJE.getOdgovorBr1Srpski());
            btnAnswer2.setText(TRENUTNO_PITANJE.getOdgovorBr2Srpski());
            btnAnswer3.setText(TRENUTNO_PITANJE.getOdgovorBr3Srpski());
            btnAnswer4.setText(TRENUTNO_PITANJE.getOdgovorBr4Srpski());
        }
        //Set listeners
        btnNextQuestion.setOnClickListener(v -> {
            //Go to the Results fragment if we walked through all questions
            if(QuizGameActivity.QUESTION_COUNTER + 1 == QuizGameActivity.QUESTIONS_PER_CHATEGORY*4)
                ((QuizGameActivity)getActivity()).setViewPager(4);
            else {
                //Move to the next question
                QuizGameActivity.nextQuestion();
                ((QuizGameActivity)getActivity()).setViewPager(databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE).getTipPitanja());
            }
        });
        btnHint.setOnClickListener(v -> {
                if(QuizGameActivity.HINT_COUNTER != 0){
                    mpHint.start();
                    QuizGameActivity.HINT_COUNTER--;
                    if("en".equals(MainActivity.lang))
                        Toast.makeText(getContext(), TRENUTNO_PITANJE.getHintEngleski(), Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getContext(), TRENUTNO_PITANJE.getHintSrpski(), Toast.LENGTH_LONG).show();
                }
                btnHint.setVisibility(View.INVISIBLE);
            });
        btnAnswer1.setOnClickListener(v -> processButtonClick(btnAnswer1));
        btnAnswer2.setOnClickListener(v -> processButtonClick(btnAnswer2));
        btnAnswer3.setOnClickListener(v -> processButtonClick(btnAnswer3));
        btnAnswer4.setOnClickListener(v -> processButtonClick(btnAnswer4));

        return view;
    }
    //Process answer button click
    private void processButtonClick(Button btnAnswer){
        btnHint.setVisibility(View.GONE);
        //Check the answer
        boolean corectlyAnswered = false;
        if((btnAnswer.getText()).equals(TRENUTNO_PITANJE.getTacniOdgovoriEngleski()))
            corectlyAnswered = true;
        if((btnAnswer.getText()).equals(TRENUTNO_PITANJE.getTacniOdgovoriSrpski()))
            corectlyAnswered = true;
        //Add answer to answer list
        QuizGameActivity.listaStringOdgovora.add(btnAnswer.getText().toString());
        //Show message about corectness
        if(corectlyAnswered){
            QuizGameActivity.listaTacnostiOdgovora.add(true);
            //Increment points
            ++QuizGameActivity.POINTS_COUNTER;
            ((QuizGameActivity)getActivity()).incrementPointsView();
            //Show message of correct answer
            txvCornectnessMessage.setText(getString(R.string.correct_answer_message));
            txvCornectnessMessage.setTextColor(getResources().getColor(R.color.primary));
            txvCornectnessMessage.setVisibility(View.VISIBLE);
            imgView.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
            imgView.setVisibility(View.VISIBLE);
            //SOUND EFFECT
            mpCorrect.start();
        }else{
            QuizGameActivity.listaTacnostiOdgovora.add(false);
            String correctAnswer = "en".equals(MainActivity.lang)?TRENUTNO_PITANJE.getTacniOdgovoriEngleski():TRENUTNO_PITANJE.getTacniOdgovoriSrpski();
            txvCornectnessMessage.setText(getString(R.string.wrong_answer_message) + " " + correctAnswer);
            txvCornectnessMessage.setTextColor(getResources().getColor(R.color.accent));
            txvCornectnessMessage.setVisibility(View.VISIBLE);
            imgView.setImageResource(R.drawable.ic_baseline_cancel_24);
            imgView.setVisibility(View.VISIBLE);
            //SOUND EFFECT
            mpWrong.start();
        }
        //DISABLE OTHER BUTTONS
        btnAnswer1.setClickable(false);btnAnswer2.setClickable(false);
        btnAnswer3.setClickable(false);btnAnswer4.setClickable(false);
    }

}