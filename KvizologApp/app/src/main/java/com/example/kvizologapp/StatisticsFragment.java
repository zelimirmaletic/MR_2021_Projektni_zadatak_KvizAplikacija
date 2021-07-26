package com.example.kvizologapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvizologapp.data.database.KvizologDatabase;
import com.example.kvizologapp.data.model.Igra;
import com.example.kvizologapp.igra_recyclerview.Adapter;

import java.util.List;

public class StatisticsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Igra> array;



    public StatisticsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        //Get data from the database
        KvizologDatabase database = KvizologDatabase.getInstance(getActivity());
        //Get data from the database
        array = database.igraDAO().readAll();

        // take a reference to RecyclerView
        recyclerView = view.findViewById(R.id.rv_recyclerView);
        // optimization
        recyclerView.setHasFixedSize(true);
        // set layout type LayoutManager-a
        layoutManager = new LinearLayoutManager((MainScreenAcitivty)getActivity());
        recyclerView.setLayoutManager(layoutManager);
        // send Adapter items from the list
        mAdapter = new Adapter(array, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Igra item) {
                Toast.makeText(getActivity(), "OPEN DETAILED GAME HISTORY!", Toast.LENGTH_SHORT).show();
            }
        });

        // connect RecyclerView with adapter
        recyclerView.setAdapter(mAdapter);

        return view;
    }


}