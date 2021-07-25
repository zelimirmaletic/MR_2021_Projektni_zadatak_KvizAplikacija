package com.example.kvizologapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kvizologapp.data.model.Igra_ima_Pitanje;
import com.example.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface Igra_Ima_PitanjeDAO {
    @Insert
    long insert(Igra_ima_Pitanje igra_ima_pitanje);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA_IMA_PITANJE)
    List<Igra_ima_Pitanje> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA_IMA_PITANJE + " WHERE IdIgra= :IdIgra ")
    List<Igra_ima_Pitanje> readByIdIgra(int IdIgra);

    @Update
    void update(Igra_ima_Pitanje igra_ima_pitanje);

    @Delete
    void delete(Igra_ima_Pitanje igra_ima_pitanje);

}
