package com.example.kvizologapp.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.kvizologapp.util.Constants;
import org.jetbrains.annotations.NotNull;
import java.io.Serializable;

@Entity(tableName = Constants.TABLE_NAME_GRAD)
public class Grad implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nazivSR;
    private String nazivEN;
    private double latitude;
    private double longitude;
    private String slika;

    public Grad(String nazivSR, String nazivEN, double latitude, double longitude, String slika) {
        this.nazivSR = nazivSR;
        this.nazivEN = nazivEN;
        this.latitude = latitude;
        this.longitude = longitude;
        this.slika = slika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivSR() {
        return nazivSR;
    }

    public void setNazivSR(String nazivSR) {
        this.nazivSR = nazivSR;
    }

    public String getNazivEN() {
        return nazivEN;
    }

    public void setNazivEN(String nazivEN) {
        this.nazivEN = nazivEN;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return super.toString();
    }

    public static Grad[] populateData() {
        return new Grad[]{
                new Grad("Београд","Belgrade",44.81333916817276, 20.405385276230323,"belgrade"),
                new Grad("Moсква","Moscow",55.755224586261605, 37.622779060216146,"moscow"),
                new Grad("Кијев","Kiev",50.43381526432757, 30.50538997660183,"kiev"),
                new Grad("Владивосток","Vladivostok",43.11987671218387, 131.91698288123035,"vladivostok"),
                new Grad("Марибор", "Maribor", 46.551638615673454, 15.650041815403565, "maribor"),
                new Grad("Љубљана", "Ljubljana", 46.06465253343343, 14.519050495837801,"ljubljana"),
                new Grad("Скопље", "Skopje", 42.01000274676726, 21.44825480033277, "skopje"),
                new Grad("Нови Сад", "Novi Sad",45.255717107932675, 19.8206354896711,"novi_sad"),
                new Grad("Требиње", "Trebinje", 42.712759690956474, 18.344160944858064, "trebinje"),
                new Grad("Лондон", "London", 51.50841446691904, -0.11744810108000202, "london"),
                new Grad("Берлин", "Berlin", 52.52879368297067, 13.407008832467843, "berlin"),
                new Grad("Единбург","Edinburg",55.95153694250245, -3.1826527507341145,"edinburg"),
                new Grad("Париз", "Paris", 48.86378383241526, 2.3505006065777803, "paris"),
                new Grad("Хамбург","Hamburg", 53.529732509890636, 10.008713996863134,"hamburg"),
                new Grad("Хановер","Hanover",52.38340403854037, 9.74911603981307,"hanover"),
                new Grad("Минхен", "Munich", 48.161589919360296, 11.559025323156291, "munich"),
                new Grad("Хераклион", "Heraklion",35.338534341187035, 25.133189305735215,"heraklion"),
                new Grad("Атина", "Atina", 37.9916385043873, 23.738511383524774,"atina"),
                new Grad("Тесалоники", "Thessaloniki", 40.63082182612092, 22.952728435419665,"thessaloniki"),
                new Grad("Барселона", "Barcelona",41.40837997680301, 2.1745401063385335,"barcelona")
        };
    }
}
