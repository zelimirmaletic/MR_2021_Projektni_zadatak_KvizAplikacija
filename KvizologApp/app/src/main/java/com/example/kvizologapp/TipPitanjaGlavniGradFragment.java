package com.example.kvizologapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TipPitanjaGlavniGradFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipPitanjaGlavniGradFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    Button btnNextQuestion;

    public TipPitanjaGlavniGradFragment() {
        // Required empty public constructor
    }
    public static TipPitanjaGlavniGradFragment newInstance(String param1, String param2) {
        TipPitanjaGlavniGradFragment fragment = new TipPitanjaGlavniGradFragment();
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
        View view = inflater.inflate(R.layout.fragment_tip_pitanja_glavni_grad, container, false);
        btnNextQuestion = (Button) view.findViewById(R.id.btnNextQuestion);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuizGameActivity)getActivity()).setViewPager(1);//go to the next question type
            }
        });

        return view;
    }
}