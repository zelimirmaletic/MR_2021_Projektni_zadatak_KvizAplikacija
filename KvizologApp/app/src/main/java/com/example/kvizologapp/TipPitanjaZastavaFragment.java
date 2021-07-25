package com.example.kvizologapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class TipPitanjaZastavaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;
    ArrayList<Button> disabledButtons;
    private static List<Character> CYRILIC_LETTERS = Arrays.asList('А','Б','В','Г','Д','Ђ','Е','Ж','З','И','Ј','К','Л','Љ','М','Н','Њ','О','П','Р','С','Т','Ћ','У','Ф','Х','Ц','Ч','Џ','Ш');
    Button clearEntry, btnNextQuestion, btnSpace, btnHint, btnCheck;
    TextView txbCountryName, txvCornectnessMessage;
    ImageView imgFlag, imgView;
    MediaPlayer mpCorrect, mpWrong, mpHint;
    Vibrator vibe;
    private static short VIBRATION_DURATION = 50;
    private static final int MAX_NUM_OF_LETTERS = 20;
    private static final int NUM_OF_LETTER_BUTTONS = 20;
    Pitanje TRENUTNO_PITANJE;
    KvizologDatabase databaseInstance;



    private String mParam1;
    private String mParam2;

    public TipPitanjaZastavaFragment() {
    }

    public static TipPitanjaZastavaFragment newInstance(String param1, String param2) {
        TipPitanjaZastavaFragment fragment = new TipPitanjaZastavaFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tip_pitanja_zastava, container, false);
        //Instatiate database
        databaseInstance = ((QuizGameActivity)getActivity()).getDatabaseInstance();
        TRENUTNO_PITANJE = databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE);

        txbCountryName = view.findViewById(R.id.txbCountryName);
        clearEntry=(Button)view.findViewById(R.id.btnClear);
        //btnSpace = (Button)view.findViewById(R.id.btnSpace);
        imgFlag = (ImageView) view.findViewById(R.id.imgFlag);
        txvCornectnessMessage = (TextView) view.findViewById(R.id.txbCorectnessMessage);
        btnNextQuestion = (Button) view.findViewById(R.id.btnNextQuestion);
        btnHint = (Button) view.findViewById(R.id.btnHint);
        btnCheck = (Button) view.findViewById(R.id.btnCheck);
        imgView = (ImageView) view.findViewById(R.id.imageView);
        vibe = (Vibrator) ((QuizGameActivity)getActivity()).getSystemService(Context.VIBRATOR_SERVICE);
        mpCorrect = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.correct);
        mpWrong = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.wrong);
        mpHint = MediaPlayer.create(((QuizGameActivity)getActivity()),R.raw.hint);
        disabledButtons = new ArrayList<>();


        //Hide hint if it is already used 3 times
        if(QuizGameActivity.HINT_COUNTER == 0)
            btnHint.setVisibility(View.GONE);

        //Initialize views from Pitanje object
        imgFlag.setImageResource(getResources().getIdentifier(TRENUTNO_PITANJE.getSlika(),"drawable",((QuizGameActivity)getActivity()).getPackageName()));
        initializeLetterButtons(view);
        setListeners();
        if("en".equals(MainActivity.lang))
            setAndRandomizeLetterButtons(TRENUTNO_PITANJE.getOdgovorBr1Engleski());
        else
            setAndRandomizeLetterButtons(TRENUTNO_PITANJE.getOdgovorBr1Srpski());
        return view;
    }

    private void initializeLetterButtons(View view){
        btn1=(Button)view.findViewById(R.id.btnLetter1);
        btn2=(Button)view.findViewById(R.id.btnLetter2);
        btn3=(Button)view.findViewById(R.id.btnLetter3);
        btn4=(Button)view.findViewById(R.id.btnLetter4);
        btn5=(Button)view.findViewById(R.id.btnLetter5);
        btn6=(Button)view.findViewById(R.id.btnLetter6);
        btn7=(Button)view.findViewById(R.id.btnLetter7);
        btn8=(Button)view.findViewById(R.id.btnLetter8);
        btn9=(Button)view.findViewById(R.id.btnLetter9);
        btn10=(Button)view.findViewById(R.id.btnLetter10);
        btn11=(Button)view.findViewById(R.id.btnLette11);
        btn12=(Button)view.findViewById(R.id.btnLetter12);
        btn13=(Button)view.findViewById(R.id.btnLetter13);
        btn14=(Button)view.findViewById(R.id.btnLetter14);
        btn15=(Button)view.findViewById(R.id.btnLetter15);
        btn16=(Button)view.findViewById(R.id.btnLetter16);
        btn17=(Button)view.findViewById(R.id.btnLetter17);
        btn18=(Button)view.findViewById(R.id.btnLetter18);
        btn19=(Button)view.findViewById(R.id.btnLetter19);
        btn20=(Button)view.findViewById(R.id.btnLetter20);
    }

    private void setListeners(){
        btn1.setOnClickListener(v -> { writeLetter(btn1); });
        btn2.setOnClickListener(v -> { writeLetter(btn2); });
        btn3.setOnClickListener(v -> { writeLetter(btn3); });
        btn4.setOnClickListener(v -> { writeLetter(btn4); });
        btn5.setOnClickListener(v -> { writeLetter(btn5); });
        btn6.setOnClickListener(v -> { writeLetter(btn6); });
        btn7.setOnClickListener(v -> { writeLetter(btn7); });
        btn8.setOnClickListener(v -> { writeLetter(btn8); });
        btn9.setOnClickListener(v -> { writeLetter(btn9); });
        btn10.setOnClickListener(v -> { writeLetter(btn10); });
        btn11.setOnClickListener(v -> { writeLetter(btn11); });
        btn12.setOnClickListener(v -> { writeLetter(btn12); });
        btn13.setOnClickListener(v -> { writeLetter(btn13); });
        btn14.setOnClickListener(v -> { writeLetter(btn14); });
        btn15.setOnClickListener(v -> { writeLetter(btn15); });
        btn16.setOnClickListener(v -> { writeLetter(btn16); });
        btn17.setOnClickListener(v -> { writeLetter(btn17); });
        btn18.setOnClickListener(v -> { writeLetter(btn18); });
        btn19.setOnClickListener(v -> { writeLetter(btn19); });
        btn20.setOnClickListener(v -> { writeLetter(btn20); });
        btnNextQuestion.setOnClickListener(v -> {
            //Go to the Results fragment if we walked through all questions
            if(QuizGameActivity.QUESTION_COUNTER + 1 == QuizGameActivity.QUESTIONS_PER_CHATEGORY*4)
                ((QuizGameActivity)getActivity()).setViewPager(4);
            else {
                //Move to the next question
                QuizGameActivity.nextQuestion();
                ((QuizGameActivity) getActivity()).setViewPager(databaseInstance.pitanjeDAO().getById(QuizGameActivity.INT_TRENUTNO_PITANJE).getTipPitanja());//go to the next question type
            }
        });
        clearEntry.setOnClickListener(v -> {
            txbCountryName.setText("");
            for(Button btn : disabledButtons)
            {
                btn.setEnabled(true);
                btn.setBackgroundColor(getResources().getColor(R.color.primary_dark));
            }
            disabledButtons.clear();
        });
        /*btnSpace.setOnClickListener(v -> {
            if(txbCountryName.getText().toString().length()<MAX_NUM_OF_LETTERS)
                txbCountryName.setText(txbCountryName.getText().toString().concat(" "));
        });
         */
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
            //Check the answer
            boolean corectlyAnswered = false;
            if((txbCountryName.getText()).equals(TRENUTNO_PITANJE.getOdgovorBr1Engleski()))
                corectlyAnswered = true;
            if((txbCountryName.getText()).equals(TRENUTNO_PITANJE.getOdgovorBr1Srpski()))
                corectlyAnswered = true;
            //Show message about corectness
            if(corectlyAnswered){
                //Increment points
                QuizGameActivity.listaOdgovora.add(true);
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
                QuizGameActivity.listaOdgovora.add(false);
                String correctAnswer = "en".equals(MainActivity.lang)?TRENUTNO_PITANJE.getOdgovorBr1Engleski():TRENUTNO_PITANJE.getOdgovorBr1Srpski();
                txvCornectnessMessage.setText(getString(R.string.wrong_answer_message) + " " + correctAnswer);
                txvCornectnessMessage.setTextColor(getResources().getColor(R.color.accent));
                txvCornectnessMessage.setVisibility(View.VISIBLE);
                imgView.setImageResource(R.drawable.ic_baseline_cancel_24);
                imgView.setVisibility(View.VISIBLE);
                //SOUND EFFECT
                mpWrong.start();
            }
            //DISABLE CHECK BUTTONS
            btnCheck.setEnabled(false);
            btnCheck.setBackgroundColor(getResources().getColor(R.color.primary_light));
        });
    }

    private void writeLetter(Button button){
        //VIBRATION EFFECT
        vibe.vibrate(VIBRATION_DURATION);
        //FILL TEXT VIEW WITH A LETTER
        if(txbCountryName.getText().toString().length()<MAX_NUM_OF_LETTERS)
            txbCountryName.setText(txbCountryName.getText().toString().concat(button.getText().toString()));
        button.setEnabled(false);
        button.setBackgroundColor(getResources().getColor(R.color.primary_light));
        disabledButtons.add(button);
    }

    private void setAndRandomizeLetterButtons(String requiredLetters){
        Random r = new Random();
        ArrayList<Character> letters = new ArrayList<>();
        for(int i=0;i<requiredLetters.length();i++)
            letters.add(requiredLetters.charAt(i));

        if("en".equals(MainActivity.lang))
            for(int i=0;i<NUM_OF_LETTER_BUTTONS-requiredLetters.length();i++)
                letters.add((char)(r.nextInt(26) + 'A'));
        else
            for(int i=0;i<NUM_OF_LETTER_BUTTONS-requiredLetters.length();i++)
                letters.add((CYRILIC_LETTERS.get(r.nextInt(30))));

        Collections.shuffle(letters);

        btn1.setText(Character.toString(letters.get(0)));
        btn2.setText(Character.toString(letters.get(1)));
        btn3.setText(Character.toString(letters.get(2)));
        btn4.setText(Character.toString(letters.get(3)));
        btn5.setText(Character.toString(letters.get(4)));
        btn6.setText(Character.toString(letters.get(5)));
        btn7.setText(Character.toString(letters.get(6)));
        btn8.setText(Character.toString(letters.get(7)));
        btn9.setText(Character.toString(letters.get(8)));
        btn10.setText(Character.toString(letters.get(9)));
        btn11.setText(Character.toString(letters.get(10)));
        btn12.setText(Character.toString(letters.get(11)));
        btn13.setText(Character.toString(letters.get(12)));
        btn14.setText(Character.toString(letters.get(13)));
        btn15.setText(Character.toString(letters.get(14)));
        btn16.setText(Character.toString(letters.get(15)));
        btn17.setText(Character.toString(letters.get(16)));
        btn18.setText(Character.toString(letters.get(17)));
        btn19.setText(Character.toString(letters.get(18)));
        btn20.setText(Character.toString(letters.get(19)));
    }

}