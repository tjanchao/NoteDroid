package be.ehb.notedroid;

import java.util.Date;

/**
 * Created by Q on 20-2-2018.
 */

public class Note {

    private String titel;
    private String inhoud;
    private Date aanmaakDatum;
    private Date laatsteWijziging;


    public Note(String titel, String inhoud) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakDatum = new Date();
        this.laatsteWijziging = new Date();
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
}
