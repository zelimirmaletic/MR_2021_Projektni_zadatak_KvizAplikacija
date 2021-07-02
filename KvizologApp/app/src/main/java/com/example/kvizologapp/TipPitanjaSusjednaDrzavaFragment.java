package com.example.kvizologapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TipPitanjaSusjednaDrzavaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipPitanjaSusjednaDrzavaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnNextQuestion;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TipPitanjaSusjednaDrzavaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipPitanjaSusjednaDrzavaFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_tip_pitanja_susjedna_drzava, container, false);
         btnNextQuestion = (Button) view.findViewById(R.id.btnNextQuestion);


         btnNextQuestion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ((QuizGameActivity)getActivity()).setViewPager(3);//go to the next question type
             }
         });


        return view;
    }
}