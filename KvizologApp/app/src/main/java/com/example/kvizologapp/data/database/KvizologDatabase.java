package com.example.kvizologapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.kvizologapp.data.dao.PitanjeDAO;
import com.example.kvizologapp.data.model.Pitanje;
import com.example.kvizologapp.util.Constants;

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
                Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public  void cleanUp(){
        kvizologDB = null;
    }


}
