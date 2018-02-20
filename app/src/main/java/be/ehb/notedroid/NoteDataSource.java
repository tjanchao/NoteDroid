package be.ehb.notedroid;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Q on 20-2-2018.
 */

public class NoteDataSource {

    private static ArrayList<Note>noteList;

    private static final NoteDataSource INSTANCE = new NoteDataSource();

    private NoteDataSource() {
        noteList = new ArrayList<>();

        noteList.add(new Note("blkdsbj","bsadhkje"));
        noteList.add(new Note("poiyv","jisdof"));
        noteList.add(new Note("nbiw","nksdfj"));


    }

    public ArrayList<Note> getNoteList() {//static hier gedelete
        return noteList;
    }

    public static NoteDataSource getINSTANCE() {
        return INSTANCE;
    }

    public void insertNote(Note n){
        noteList.add(n);
    }




}
