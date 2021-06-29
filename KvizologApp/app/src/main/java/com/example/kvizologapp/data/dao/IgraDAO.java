package com.example.kvizologapp.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kvizologapp.data.model.Igra;
import com.example.kvizologapp.data.model.Pitanje;
import com.example.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface IgraDAO {
    @Insert
    long insert(Igra igra);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA)
    List<Igra> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA + " WHERE email= :Email ")
    List<Igra> readByUserEmail(String Email);

    @Update
    void update(Igra igra);

    @Delete
    void delete(Igra igra);


}
