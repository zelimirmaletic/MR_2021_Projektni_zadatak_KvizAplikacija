package com.example.kvizologapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvizologapp.data.database.KvizologDatabase;
import com.example.kvizologapp.data.model.Igra_ima_Pitanje;
import com.example.kvizologapp.pitanje_recyclerview.Adapter;

import java.util.List;

public class AnsweredQuestionsListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Igra_ima_Pitanje> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answered_questions_list);
        //Get data from the database
        KvizologDatabase database = KvizologDatabase.getInstance(this);
        //Get game id through getExtra() for which we load questions
        int idIgra = getIntent().getIntExtra("id_game",1);
        //Get data from the database
        array = database.igra_ima_pitanjeDAO().readByIdIgra(idIgra); //Call read all by ID game! TO-DO
        // take a reference to RecyclerView
        recyclerView = findViewById(R.id.rv_recyclerView);
        // optimization
        recyclerView.setHasFixedSize(true);
        // set layout type LayoutManager-a
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // send Adapter items from the list
        mAdapter = new Adapter(array, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Igra_ima_Pitanje item) {
                //Implement on click action if needed
            }
        });
        // connect RecyclerView with adapter
        recyclerView.setAdapter(mAdapter);
    }
}