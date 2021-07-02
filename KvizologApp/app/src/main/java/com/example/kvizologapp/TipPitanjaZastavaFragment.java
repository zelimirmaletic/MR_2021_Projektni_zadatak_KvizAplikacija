package com.example.kvizologapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TipPitanjaZastavaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipPitanjaZastavaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;
    Button clearEntry;
    TextView flagName;
    private static final int MAX_NUM_OF_LETTERS = 20;


    private String mParam1;
    private String mParam2;

    public TipPitanjaZastavaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipPitanjaZastavaFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        initializeLetterButtons(view);
        setListeners();
        flagName = view.findViewById(R.id.txbCountryName);


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
        clearEntry=(Button)view.findViewById(R.id.btnClear);
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
        clearEntry.setOnClickListener(v -> {flagName.setText("");});

    }

    private void writeLetter(Button button){
        if(flagName.getText().toString().length()<MAX_NUM_OF_LETTERS)
            flagName.setText(flagName.getText().toString().concat(button.getText().toString()));
    }

    private void setAndRandomizeLetterButtons(String requiredLetters){
        ArrayList<String> letters = new ArrayList<>();
        //String[] requiredLetters = letters. FINISH THIS FUNCTION FOR RANDOMIZATION!!!
    }

}