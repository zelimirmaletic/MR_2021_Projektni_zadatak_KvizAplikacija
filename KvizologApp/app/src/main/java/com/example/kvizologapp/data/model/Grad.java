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
}
