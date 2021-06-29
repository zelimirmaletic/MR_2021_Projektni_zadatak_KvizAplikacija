package com.example.kvizologapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.kvizologapp.util.Constants;

import java.io.Serializable;

@Entity(tableName = Constants.TABLE_NAME_IGRA_IMA_PITANJE)
public class Igra_ima_Pitanje implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int IdPitanje;
    private int IdIgra;
    private boolean jeTacnoOdgovoreno;

    public Igra_ima_Pitanje(int idPitanje, int idIgra, boolean jeTacnoOdgovoreno) {
        IdPitanje = idPitanje;
        IdIgra = idIgra;
        this.jeTacnoOdgovoreno = jeTacnoOdgovoreno;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdPitanje() {
        return IdPitanje;
    }

    public void setIdPitanje(int idPitanje) {
        IdPitanje = idPitanje;
    }

    public int getIdIgra() {
        return IdIgra;
    }

    public void setIdIgra(int idIgra) {
        IdIgra = idIgra;
    }

    public boolean isJeTacnoOdgovoreno() {
        return jeTacnoOdgovoreno;
    }

    public void setJeTacnoOdgovoreno(boolean jeTacnoOdgovoreno) {
        this.jeTacnoOdgovoreno = jeTacnoOdgovoreno;
    }

    @Override
    public String toString() {
        return "Igra_ima_Pitanje{" +
                "Id=" + Id +
                ", IdPitanje=" + IdPitanje +
                ", IdIgra=" + IdIgra +
                ", jeTacnoOdgovoreno=" + jeTacnoOdgovoreno +
                '}';
    }
}
