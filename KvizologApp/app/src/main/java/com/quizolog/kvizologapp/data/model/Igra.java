package com.quizolog.kvizologapp.data.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.quizolog.kvizologapp.util.Constants;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = Constants.TABLE_NAME_IGRA)
public class Igra implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private Long date;
    private String email;
    private int points;

    public Igra(Long date, String email,int points) {
        this.date = date;
        this.points = points;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Igra)) return false;
        Igra igra = (Igra) o;
        return getId() == igra.getId() &&
                Objects.equals(getDate(), igra.getDate()) &&
                Objects.equals(getEmail(), igra.getEmail());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getEmail());
    }

    @Override
    public String toString() {
        return "Igra{" +
                "Id=" + Id +
                ", date=" + date +
                ", email='" + email + '\'' +
                '}';
    }
}