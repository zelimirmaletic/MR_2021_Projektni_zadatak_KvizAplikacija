package com.example.kvizologapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kvizologapp.data.database.KvizologDatabase;
import com.example.kvizologapp.data.model.Pitanje;

public class TipPitanjaSusjednaDrzavaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnNextQuestion, btnHint, btnCheck;
    //Sound efects
    MediaPlayer mpCorrect, mpWrong, mpHint;
    ImageView imgView;
    TextView tvCountryName, txvCornectnessMessage;
    CheckBox cbAnswer1, cbAnswer2, cbAnswer3, cbAnswer4;
    Pitanje TRENUTNO_PITANJE;


    private String mParam1;
    private String mParam2;

    public TipPitanjaSusjednaDrzavaFragment() {
        // Required empty public constructor
    }

    public static TipPitanjaSusjednaDrzavaFragment newInstance(String param1, String param2) {
        TipPitanjaSusjednaDrzavaFragment fragment = new TipPitanjaSusjednaDrzavaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_tip_pitanja_susjedna_drzava, container, false);
        btnNextQuestion = (Button) view.findViewById(R.id.btnNextQuestion);
        tvCountryName = (TextView) view.findViewById(R.id.txbCountryName);
        txvCornectnessMessage = (TextView) view.findViewById(R.id.tvCorectnessMessage);
        CheckBox cbAnswer1 = (CheckBox) view.findViewById(R.id.cbAnswer1);
        CheckBox cbAnswer2 = (CheckBox) view.findViewById(R.id.cbAnswer2);
        CheckBox cbAnswer3 = (CheckBox) view.findViewById(R.id.cbAnswer3);
        CheckBox cbAnswer4 = (CheckBox) view.findViewById(R.id.cbAnswer4);
        btnCheck = (Button) view.findViewById(R.id.btnCheck);
        imgView =(ImageView) view.findViewById(R.id.imageView);
        btnHint = (Button) view.findViewById(R.id.btnHint);
        mpCorrect = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.correct);
        mpWrong = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.wrong);
        mpHint = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.hint);

        //Instatiate database
        KvizologDatabase databaseInstance = KvizologDatabase.getInstance(getContext());
        TRENUTNO_PITANJE = databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE);


        //Initialize question data
        if("en".equals(MainActivity.lang)){
            tvCountryName.setText(TRENUTNO_PITANJE.getTekstPitanjaEngleski());
            cbAnswer1.setText(TRENUTNO_PITANJE.getOdgovorBr1Engleski());
            cbAnswer2.setText(TRENUTNO_PITANJE.getOdgovorBr2Engleski());
            cbAnswer3.setText(TRENUTNO_PITANJE.getOdgovorBr3Engleski());
            cbAnswer4.setText(TRENUTNO_PITANJE.getOdgovorBr4Engleski());
        }else {
            tvCountryName.setText(TRENUTNO_PITANJE.getTekstPitanjaSrpski());
            cbAnswer1.setText(TRENUTNO_PITANJE.getOdgovorBr1Srpski());
            cbAnswer2.setText(TRENUTNO_PITANJE.getOdgovorBr2Srpski());
            cbAnswer3.setText(TRENUTNO_PITANJE.getOdgovorBr3Srpski());
            cbAnswer4.setText(TRENUTNO_PITANJE.getOdgovorBr4Srpski());
        }


        btnNextQuestion.setOnClickListener(v -> {
            //Go to the Results fragment if we walked through all questions
            if(QuizGameActivity.QUESTION_COUNTER == QuizGameActivity.SHOWED_NUMBER_OF_QUESTIONS_PER_CHATEGORY*4)
                ((QuizGameActivity)getActivity()).setViewPager(4);
            else {
                //Move to the next question
                QuizGameActivity.nextQuestion();
                ((QuizGameActivity) getActivity()).setViewPager(databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE).getTipPitanja());//go to the next question type
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
        btnCheck.setOnClickListener(v -> {
            btnHint.setVisibility(View.GONE);

            boolean corectlyAnswered = true;
            //Check the corectness of the answer
            if("en".equals(MainActivity.lang)){
                if(cbAnswer1.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriEngleski().contains(cbAnswer1.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer2.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriEngleski().contains(cbAnswer2.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer3.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriEngleski().contains(cbAnswer3.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer4.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriEngleski().contains(cbAnswer4.getText().toString()))
                    corectlyAnswered=false;
            }else{
                if(cbAnswer1.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriSrpski().contains(cbAnswer1.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer2.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriSrpski().contains(cbAnswer2.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer3.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriSrpski().contains(cbAnswer3.getText().toString()))
                    corectlyAnswered=false;
                else if(cbAnswer4.isChecked() && ! TRENUTNO_PITANJE.getTacniOdgovoriSrpski().contains(cbAnswer4.getText().toString()))
                    corectlyAnswered=false;
            }
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
                String correctAnswer = "en".equals(MainActivity.lang)?TRENUTNO_PITANJE.getTacniOdgovoriEngleski():TRENUTNO_PITANJE.getTacniOdgovoriSrpski();
                txvCornectnessMessage.setText(getString(R.string.wrong_answer_message) + " " + correctAnswer);
                txvCornectnessMessage.setTextColor(getResources().getColor(R.color.accent));
                txvCornectnessMessage.setVisibility(View.VISIBLE);
                imgView.setImageResource(R.drawable.ic_baseline_cancel_24);
                imgView.setVisibility(View.VISIBLE);
                //SOUND EFFECT
                mpWrong.start();
            }
            //DISABLE CHECK BUTTON
            btnCheck.setEnabled(false);
            btnCheck.setBackgroundColor(getResources().getColor(R.color.primary_light));
            cbAnswer1.setClickable(false);cbAnswer2.setClickable(false);cbAnswer3.setClickable(false);cbAnswer4.setClickable(false);
        });

        return view;
    }
}