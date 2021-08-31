package com.quizolog.kvizologapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.quizolog.kvizologapp.data.model.Grad;
import com.quizolog.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface GradDAO {
    @Insert
    long insert(Grad grad);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD)
    List<Grad> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD + " WHERE nazivSR= :name ")
    Grad readByNameSR(String name);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_GRAD + " WHERE nazivEN= :name ")
    Grad readByNameEN(String name);

    @Update
    void update(Grad grad);

    @Insert
    void insertAll(Grad... listaGradova);

    @Delete
    void delete(Grad grad);
}
