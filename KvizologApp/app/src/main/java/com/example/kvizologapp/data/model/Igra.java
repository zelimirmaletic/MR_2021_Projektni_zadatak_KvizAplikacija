package com.example.kvizologapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.kvizologapp.util.Constants;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(tableName = Constants.TABLE_NAME_IGRA)
public class Igra implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private Date date;
    private String email;

    public Igra(Date date, String email) {
        this.date = date;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
