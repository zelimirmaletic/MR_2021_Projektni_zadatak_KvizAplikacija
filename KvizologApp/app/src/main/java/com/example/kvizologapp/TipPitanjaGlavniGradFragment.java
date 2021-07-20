package com.example.kvizologapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class TipPitanjaGlavniGradFragment extends Fragment {


    //Sound efects
    MediaPlayer mpCorrect, mpWrong, mpHint;
    Button btnNextQuestion, btnHint;
    TextView txbCountryName, txvCornectnessMessage;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    ImageButton btnInfo1,btnInfo2, btnInfo3, btnInfo4;
    ImageButton btnMap1, btnMap2, btnMap3, btnMap4;
    ImageView imgView;

    public TipPitanjaGlavniGradFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tip_pitanja_glavni_grad, container, false);
        btnNextQuestion = view.findViewById(R.id.btnNextQuestion);
        txbCountryName = view.findViewById(R.id.txbCountryName);
        btnAnswer1 = view.findViewById(R.id.btnAnswer1);
        btnAnswer2 = view.findViewById(R.id.btnAnswer2);
        btnAnswer3 = view.findViewById(R.id.btnAnswer3);
        btnAnswer4 = view.findViewById(R.id.btnAnswer4);
        btnHint = view.findViewById(R.id.btnHint);
        btnInfo1 = view.findViewById(R.id.btnInfo1);
        btnInfo2 = view.findViewById(R.id.btnInfo2);
        btnInfo3 = view.findViewById(R.id.btnInfo3);
        btnInfo4 = view.findViewById(R.id.btnInfo4);
        btnMap1 = view.findViewById(R.id.btnLocation1);
        btnMap2 = view.findViewById(R.id.btnLocation2);
        btnMap3 = view.findViewById(R.id.btnLocation3);
        btnMap4 = view.findViewById(R.id.btnLocation4);
        imgView = view.findViewById(R.id.imageView);
        txvCornectnessMessage = view.findViewById(R.id.txbCorrectnessMessage);
        mpCorrect = MediaPlayer.create(getActivity(),R.raw.correct);
        mpWrong = MediaPlayer.create(getActivity(),R.raw.wrong);
        mpHint = MediaPlayer.create(getActivity(),R.raw.hint);

        //Show previous points
        ((QuizGameActivity)getActivity()).incrementPointsView();
        //Hide hint if it is already used 3 times
        if(QuizGameActivity.HINT_COUNTER == 0)
            btnHint.setVisibility(View.GONE);

        //Fill question data
        if("en".equals(MainActivity.lang)){
           txbCountryName.setText(QuizGameActivity.TRENUTNO_PITANJE.getTekstPitanjaEngleski());
           btnAnswer1.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr1Engleski());
           btnAnswer2.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr2Engleski());
           btnAnswer3.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr3Engleski());
           btnAnswer4.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr4Engleski());
        }else {
            txbCountryName.setText(QuizGameActivity.TRENUTNO_PITANJE.getTekstPitanjaSrpski());
            btnAnswer1.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr1Srpski());
            btnAnswer2.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr2Srpski());
            btnAnswer3.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr3Srpski());
            btnAnswer4.setText(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr4Srpski());
        }
        btnNextQuestion.setOnClickListener(v -> {
            ((QuizGameActivity)getActivity()).setViewPager(1);//go to the next question type
        });

        //Set onClick listeners
        btnAnswer1.setOnClickListener(v -> processButtonClick(btnAnswer1));
        btnAnswer2.setOnClickListener(v -> processButtonClick(btnAnswer2));
        btnAnswer3.setOnClickListener(v -> processButtonClick(btnAnswer3));
        btnAnswer4.setOnClickListener(v -> processButtonClick(btnAnswer4));
        btnMap1.setOnClickListener(v -> startActivity(new Intent(getActivity(),MapsActivity.class)));
        btnInfo1.setOnClickListener(v -> processInfoButtonClick(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr1Engleski()));
        btnInfo2.setOnClickListener(v -> processInfoButtonClick(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr2Engleski()));
        btnInfo3.setOnClickListener(v -> processInfoButtonClick(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr3Engleski()));
        btnInfo4.setOnClickListener(v -> processInfoButtonClick(QuizGameActivity.TRENUTNO_PITANJE.getOdgovorBr4Engleski()));
        btnHint.setOnClickListener(v -> {
            if(QuizGameActivity.HINT_COUNTER != 0){
                mpHint.start();
                QuizGameActivity.HINT_COUNTER--;
                if("en".equals(MainActivity.lang))
                    Toast.makeText(getContext(), QuizGameActivity.TRENUTNO_PITANJE.getHintEngleski(), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getContext(), QuizGameActivity.TRENUTNO_PITANJE.getHintSrpski(), Toast.LENGTH_LONG).show();
            }
            btnHint.setVisibility(View.INVISIBLE);
        });
        return view;
    }

    private void processButtonClick(Button btnAnswer){
        btnHint.setVisibility(View.GONE);
        setAdditionalInfoButtonsVisible();
        //Check the answer
        boolean corectlyAnswered = false;
        if((btnAnswer.getText()).equals(QuizGameActivity.TRENUTNO_PITANJE.getTacniOdgovoriEngleski()))
            corectlyAnswered = true;
        if((btnAnswer.getText()).equals(QuizGameActivity.TRENUTNO_PITANJE.getTacniOdgovoriSrpski()))
            corectlyAnswered = true;
        //Show message about corectness
        if(corectlyAnswered){
            //Increment points
            QuizGameActivity.POINTS_COUNTER++;
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
            String correctAnswer = "en".equals(MainActivity.lang)?QuizGameActivity.TRENUTNO_PITANJE.getTacniOdgovoriEngleski():QuizGameActivity.TRENUTNO_PITANJE.getTacniOdgovoriSrpski();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(getString(R.string.wrong_answer_message));
            strBuilder.append(" ");strBuilder.append(correctAnswer);
            txvCornectnessMessage.setText(strBuilder.toString());
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

    private void setAdditionalInfoButtonsVisible(){
        btnInfo1.setVisibility(View.VISIBLE);
        btnInfo2.setVisibility(View.VISIBLE);
        btnInfo3.setVisibility(View.VISIBLE);
        btnInfo4.setVisibility(View.VISIBLE);
        btnMap1.setVisibility(View.VISIBLE);
        btnMap2.setVisibility(View.VISIBLE);
        btnMap3.setVisibility(View.VISIBLE);
        btnMap4.setVisibility(View.VISIBLE);
    }

    private void processInfoButtonClick(String cityName){
        Intent intent = new Intent(getActivity(),NewsActivity.class);
        intent.putExtra("keyword",cityName);
        startActivity(intent);
    }
}