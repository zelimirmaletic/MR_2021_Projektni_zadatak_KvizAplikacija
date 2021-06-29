package com.example.kvizologapp.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kvizologapp.data.model.Igra_ima_Pitanje;
import com.example.kvizologapp.data.model.Pitanje;
import com.example.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface Igra_Ima_PitanjeDAO {
    @Insert
    long insert(Igra_ima_Pitanje igra_ima_pitanje);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA_IMA_PITANJE)
    List<Pitanje> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_IGRA_IMA_PITANJE + " WHERE IdIgra= :IdIgra ")
    List<Igra_Ima_PitanjeDAO> readByTipPitanja(int IdIgra);

    @Update
    void update(Igra_ima_Pitanje igra_ima_pitanje);

    @Delete
    void delete(Igra_ima_Pitanje igra_ima_pitanje);

}
