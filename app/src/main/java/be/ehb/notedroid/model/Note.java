package be.ehb.notedroid.model;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Q on 20-2-2018.
 */

public class Note implements Serializable, Comparable<Note> {

    private String titel;
    private String inhoud;
    private Date aanmaakDatum;
    private Date laatsteWijziging;


    public Note(String titel, String inhoud, Date aanmaakDatum, Date laatsteWijziging) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakDatum = aanmaakDatum;
        this.laatsteWijziging = laatsteWijziging;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    public Date getLaatsteWijziging() {
        return laatsteWijziging;
    }

    public void setLaatsteWijziging(Date laatsteWijziging) {
        this.laatsteWijziging = laatsteWijziging;
    }

    @Override
    public String toString() {
        return this.titel;
    }

    @Override
    public int compareTo(@NonNull Note note) {
        return this.titel.compareTo(note.titel);
    }
}
