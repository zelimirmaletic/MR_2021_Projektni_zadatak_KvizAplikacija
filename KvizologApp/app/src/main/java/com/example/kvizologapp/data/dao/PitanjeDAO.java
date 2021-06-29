package com.example.kvizologapp.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kvizologapp.data.model.Pitanje;
import com.example.kvizologapp.util.Constants;

import java.util.List;

@Dao
public interface PitanjeDAO {
    @Insert
    long insert(Pitanje pitanje);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_PITANJE)
    List<Pitanje> readAll();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_PITANJE + " WHERE tipPitanja= :idTipPitanja ")
    List<Pitanje> readByTipPitanja(int idTipPitanja);

    @Query("SELECT * FROM " + Constants.TABLE_NAME_PITANJE + " WHERE Id=id " )
    Pitanje getById(int id);

    @Update
    void update(Pitanje pitanje);

    @Delete
    void delete(Pitanje pitanje);


}
