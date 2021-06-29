package com.example.kvizologapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.kvizologapp.util.Constants;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = Constants.TABLE_NAME_PITANJE)
public class Pitanje implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int tipPitanja;
    private String tekstPitanjaEngleski;
    private String odgovorBr1Engleski;
    private String odgovorBr2Engleski;
    private String odgovorBr3Engleski;
    private String odgovorBr4Engleski;
    private String tekstPitanjaSrpski;
    private String odgovorBr1Srpski;
    private String odgovorBr2Srpski;
    private String odgovorBr3Srpski;
    private String odgovorBr4Srpski;
    private String hintEngleski;
    private String hintSrpski;
    private String slika;

    @Ignore
    public  Pitanje(){
    }

    public Pitanje(int tipPitanja, String tekstPitanjaEngleski, String odgovorBr1Engleski, String odgovorBr2Engleski, String odgovorBr3Engleski, String odgovorBr4Engleski, String tekstPitanjaSrpski, String odgovorBr1Srpski, String odgovorBr2Srpski, String odgovorBr3Srpski, String odgovorBr4Srpski, String hintEngleski, String hintSrpski, String slika) {
        this.tipPitanja = tipPitanja;
        this.tekstPitanjaEngleski = tekstPitanjaEngleski;
        this.odgovorBr1Engleski = odgovorBr1Engleski;
        this.odgovorBr2Engleski = odgovorBr2Engleski;
        this.odgovorBr3Engleski = odgovorBr3Engleski;
        this.odgovorBr4Engleski = odgovorBr4Engleski;
        this.tekstPitanjaSrpski = tekstPitanjaSrpski;
        this.odgovorBr1Srpski = odgovorBr1Srpski;
        this.odgovorBr2Srpski = odgovorBr2Srpski;
        this.odgovorBr3Srpski = odgovorBr3Srpski;
        this.odgovorBr4Srpski = odgovorBr4Srpski;
        this.hintEngleski = hintEngleski;
        this.hintSrpski = hintSrpski;
        this.slika = slika;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(int tipPitanja) {
        this.tipPitanja = tipPitanja;
    }

    public String getTekstPitanjaEngleski() {
        return tekstPitanjaEngleski;
    }

    public void setTekstPitanjaEngleski(String tekstPitanjaEngleski) {
        this.tekstPitanjaEngleski = tekstPitanjaEngleski;
    }

    public String getOdgovorBr1Engleski() {
        return odgovorBr1Engleski;
    }

    public void setOdgovorBr1Engleski(String odgovorBr1Engleski) {
        this.odgovorBr1Engleski = odgovorBr1Engleski;
    }

    public String getOdgovorBr2Engleski() {
        return odgovorBr2Engleski;
    }

    public void setOdgovorBr2Engleski(String odgovorBr2Engleski) {
        this.odgovorBr2Engleski = odgovorBr2Engleski;
    }

    public String getOdgovorBr3Engleski() {
        return odgovorBr3Engleski;
    }

    public void setOdgovorBr3Engleski(String odgovorBr3Engleski) {
        this.odgovorBr3Engleski = odgovorBr3Engleski;
    }

    public String getOdgovorBr4Engleski() {
        return odgovorBr4Engleski;
    }

    public void setOdgovorBr4Engleski(String odgovorBr4Engleski) {
        this.odgovorBr4Engleski = odgovorBr4Engleski;
    }

    public String getTekstPitanjaSrpski() {
        return tekstPitanjaSrpski;
    }

    public void setTekstPitanjaSrpski(String tekstPitanjaSrpski) {
        this.tekstPitanjaSrpski = tekstPitanjaSrpski;
    }

    public String getOdgovorBr1Srpski() {
        return odgovorBr1Srpski;
    }

    public void setOdgovorBr1Srpski(String odgovorBr1Srpski) {
        this.odgovorBr1Srpski = odgovorBr1Srpski;
    }

    public String getOdgovorBr2Srpski() {
        return odgovorBr2Srpski;
    }

    public void setOdgovorBr2Srpski(String odgovorBr2Srpski) {
        this.odgovorBr2Srpski = odgovorBr2Srpski;
    }

    public String getOdgovorBr3Srpski() {
        return odgovorBr3Srpski;
    }

    public void setOdgovorBr3Srpski(String odgovorBr3Srpski) {
        this.odgovorBr3Srpski = odgovorBr3Srpski;
    }

    public String getOdgovorBr4Srpski() {
        return odgovorBr4Srpski;
    }

    public void setOdgovorBr4Srpski(String odgovorBr4Srpski) {
        this.odgovorBr4Srpski = odgovorBr4Srpski;
    }

    public String getHintEngleski() {
        return hintEngleski;
    }

    public void setHintEngleski(String hintEngleski) {
        this.hintEngleski = hintEngleski;
    }

    public String getHintSrpski() {
        return hintSrpski;
    }

    public void setHintSrpski(String hintSrpski) {
        this.hintSrpski = hintSrpski;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pitanje)) return false;
        Pitanje pitanje = (Pitanje) o;
        return getId() == pitanje.getId() &&
                getTipPitanja() == pitanje.getTipPitanja() &&
                Objects.equals(getTekstPitanjaEngleski(), pitanje.getTekstPitanjaEngleski()) &&
                Objects.equals(getOdgovorBr1Engleski(), pitanje.getOdgovorBr1Engleski()) &&
                Objects.equals(getOdgovorBr2Engleski(), pitanje.getOdgovorBr2Engleski()) &&
                Objects.equals(getOdgovorBr3Engleski(), pitanje.getOdgovorBr3Engleski()) &&
                Objects.equals(getOdgovorBr4Engleski(), pitanje.getOdgovorBr4Engleski()) &&
                Objects.equals(getTekstPitanjaSrpski(), pitanje.getTekstPitanjaSrpski()) &&
                Objects.equals(getOdgovorBr1Srpski(), pitanje.getOdgovorBr1Srpski()) &&
                Objects.equals(getOdgovorBr2Srpski(), pitanje.getOdgovorBr2Srpski()) &&
                Objects.equals(getOdgovorBr3Srpski(), pitanje.getOdgovorBr3Srpski()) &&
                Objects.equals(getOdgovorBr4Srpski(), pitanje.getOdgovorBr4Srpski()) &&
                Objects.equals(getHintEngleski(), pitanje.getHintEngleski()) &&
                Objects.equals(getHintSrpski(), pitanje.getHintSrpski()) &&
                Objects.equals(getSlika(), pitanje.getSlika());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipPitanja(), getTekstPitanjaEngleski(), getOdgovorBr1Engleski(), getOdgovorBr2Engleski(), getOdgovorBr3Engleski(), getOdgovorBr4Engleski(), getTekstPitanjaSrpski(), getOdgovorBr1Srpski(), getOdgovorBr2Srpski(), getOdgovorBr3Srpski(), getOdgovorBr4Srpski(), getHintEngleski(), getHintSrpski(), getSlika());
    }

    @Override
    public String toString() {
        return "Pitanje{" +
                "Id=" + Id +
                ", tipPitanja=" + tipPitanja +
                ", tekstPitanjaEngleski='" + tekstPitanjaEngleski + '\'' +
                ", odgovorBr1Engleski='" + odgovorBr1Engleski + '\'' +
                ", odgovorBr2Engleski='" + odgovorBr2Engleski + '\'' +
                ", odgovorBr3Engleski='" + odgovorBr3Engleski + '\'' +
                ", odgovorBr4Engleski='" + odgovorBr4Engleski + '\'' +
                ", tekstPitanjaSrpski='" + tekstPitanjaSrpski + '\'' +
                ", odgovorBr1Srpski='" + odgovorBr1Srpski + '\'' +
                ", odgovorBr2Srpski='" + odgovorBr2Srpski + '\'' +
                ", odgovorBr3Srpski='" + odgovorBr3Srpski + '\'' +
                ", odgovorBr4Srpski='" + odgovorBr4Srpski + '\'' +
                ", hintEngleski='" + hintEngleski + '\'' +
                ", hintSrpski='" + hintSrpski + '\'' +
                ", slika='" + slika + '\'' +
                '}';
    }
}

