package com.example.kvizologapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kvizologapp.data.model.Igra;
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
