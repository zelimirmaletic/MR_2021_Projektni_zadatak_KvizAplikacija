package com.quizolog.kvizologapp.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.quizolog.kvizologapp.data.dao.GradDAO;
import com.quizolog.kvizologapp.data.dao.IgraDAO;
import com.quizolog.kvizologapp.data.dao.Igra_Ima_PitanjeDAO;
import com.quizolog.kvizologapp.data.dao.PitanjeDAO;
import com.quizolog.kvizologapp.data.model.Grad;
import com.quizolog.kvizologapp.data.model.Igra;
import com.quizolog.kvizologapp.data.model.Igra_ima_Pitanje;
import com.quizolog.kvizologapp.data.model.Pitanje;
import com.quizolog.kvizologapp.util.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;

@Database(entities = {Pitanje.class, Igra.class, Igra_ima_Pitanje.class, Grad.class}, version = 1, exportSchema = false)
public abstract class KvizologDatabase extends RoomDatabase {
    //Get DAO
    public abstract PitanjeDAO pitanjeDAO();
    public abstract IgraDAO igraDAO();
    public abstract Igra_Ima_PitanjeDAO igra_ima_pitanjeDAO();
    public abstract GradDAO gradDAO();

    //reference
    private static KvizologDatabase kvizologDB;
    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ KvizologDatabase getInstance(Context context) {
        if (null == kvizologDB) {
            kvizologDB = buildDatabaseInstance(context);
        }
        return kvizologDB;
    }

    public static KvizologDatabase getInstance(){
        return kvizologDB;
    }

    private static KvizologDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                KvizologDatabase.class,
                Constants.DB_NAME).addCallback(new Callback() {
            @Override
            public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        //Insert all questions
                        getInstance(context).pitanjeDAO().insertAll(Pitanje.populateData());
                        //Insert all cities
                        getInstance(context).gradDAO().insertAll(Grad.populateData());
                    }
                });
            }
        }).allowMainThreadQueries().build();
    }

    public  void cleanUp(){
        kvizologDB = null;
    }

}
