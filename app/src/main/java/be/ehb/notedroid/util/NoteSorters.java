package be.ehb.notedroid.util;

import java.util.Comparator;

import be.ehb.notedroid.model.Note;

/**
 * Created by Q on 11-3-2018.
 */

public class NoteSorters {
    //comparators
    private static Comparator<Note> alphabeticNotes = new Comparator<Note>() {
        @Override
        public int compare(Note note, Note t1) {
            return note.getTitel().compareTo(t1.getTitel());
        }
    };

    private static Comparator<Note>ascendingDate = new Comparator<Note>() {
        @Override
        public int compare(Note note, Note t1) {
            return note.getAanmaakDatum().compareTo(t1.getAanmaakDatum());
        }
    };

    private static Comparator<Note>descendingDate = new Comparator<Note>() {
        @Override
        public int compare(Note note, Note t1) {
            return note.getAanmaakDatum().compareTo(t1.getAanmaakDatum());
        }
    };


    //get comparators

    public static Comparator<Note> getAlphabeticNotes() {
        return alphabeticNotes;
    }

    public static Comparator<Note> getAscendingDate() {
        return ascendingDate;
    }

    public static Comparator<Note> getDescendingDate() {
        return descendingDate;
    }
}
