package com.example.kvizologapp.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
