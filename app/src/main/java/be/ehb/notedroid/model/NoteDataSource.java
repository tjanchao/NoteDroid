package be.ehb.notedroid.model;

import java.util.ArrayList;

/**
 * Created by Q on 20-2-2018.
 */

final public class NoteDataSource {

    private ArrayList<Note> noteList;

    private static final NoteDataSource INSTANCE = new NoteDataSource();

    private NoteDataSource() {
        noteList = new ArrayList<>();

        noteList.add(new Note("blkdsbj", "bsadhkje"));
        noteList.add(new Note("poiyv", "jisdof"));
        noteList.add(new Note("nbiw", "nksdfj"));


    }

    public ArrayList<Note> getNoteList() {//static hier gedelete
        return noteList;
    }

    public static NoteDataSource getINSTANCE() {
        return INSTANCE;
    }

    public void insertNote(Note n) {
        noteList.add(n);
    }

    public void updateNote(Note n) {


        for (Note note : noteList) {
            if (note.getTitel().equals(n.getTitel()) && note.getInhoud().equals(n.getInhoud())) {
                int index = noteList.indexOf(note);

                noteList.set(index, n);

            }
        }
    }

    public void deleteNote(Note n){
        noteList.remove(n);
    }
}
