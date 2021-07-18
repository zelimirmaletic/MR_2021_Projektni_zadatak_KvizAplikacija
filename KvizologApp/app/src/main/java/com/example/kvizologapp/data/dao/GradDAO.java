package com.example.kvizologapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kvizologapp.data.model.Grad;
import com.example.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface GradDAO {
    @Insert
    long insert(Grad grad);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD)
    List<Grad> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD + " WHERE nazivSR= :name ")
    List<Grad> readByNameSR(String name);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD + " WHERE nazivEN= :name ")
    List<Grad> readByNameEN(String name);

    @Update
    void update(Grad grad);

    @Delete
    void delete(Grad grad);
}
