package com.example.kvizologapp.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.kvizologapp.data.dao.PitanjeDAO;
import com.example.kvizologapp.data.model.Pitanje;
import com.example.kvizologapp.util.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;

@Database(entities = {Pitanje.class}, version = 1, exportSchema = false)
public abstract class KvizologDatabase extends RoomDatabase {
    //Get DAO
    public abstract PitanjeDAO pitanjeDAO();


    //reference
    private static KvizologDatabase kvizologDB;
    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ KvizologDatabase getInstance(Context context) {
        if (null == kvizologDB) {
            kvizologDB = buildDatabaseInstance(context);
        }
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
                        getInstance(context).pitanjeDAO().insertAll(Pitanje.populateData());
                    }
                });
            }
        }).allowMainThreadQueries().build();
    }

    public  void cleanUp(){
        kvizologDB = null;
    }

}
