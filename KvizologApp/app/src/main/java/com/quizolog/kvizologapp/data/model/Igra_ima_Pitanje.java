package com.quizolog.kvizologapp.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.quizolog.kvizologapp.util.Constants;

import java.io.Serializable;

@Entity(tableName = Constants.TABLE_NAME_IGRA_IMA_PITANJE)
public class Igra_ima_Pitanje implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int IdPitanje;
    private int IdIgra;
    private boolean jeTacnoOdgovoreno;
    private String korisnikovOdgovor;

    public Igra_ima_Pitanje(){}

    public Igra_ima_Pitanje(int id, int idPitanje, int idIgra, boolean jeTacnoOdgovoreno,String korisnikovOdgovor) {
        Id = id;
        IdPitanje = idPitanje;
        IdIgra = idIgra;
        this.jeTacnoOdgovoreno = jeTacnoOdgovoreno;
        this.korisnikovOdgovor = korisnikovOdgovor;
    }

    public Igra_ima_Pitanje(int idPitanje, int idIgra, boolean jeTacnoOdgovoreno,String korisnikovOdgovor) {
        this.IdPitanje = idPitanje;
        this.IdIgra = idIgra;
        this.jeTacnoOdgovoreno = jeTacnoOdgovoreno;
        this.korisnikovOdgovor = korisnikovOdgovor;
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

    public String getKorisnikovOdgovor() {
        return korisnikovOdgovor;
    }

    public void setKorisnikovOdgovor(String korisnikovOdgovor) {
        this.korisnikovOdgovor = korisnikovOdgovor;
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
