package be.ehb.notedroid.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.ehb.notedroid.util.NoteListFragmentDelegate;
import be.ehb.notedroid.R;
import be.ehb.notedroid.fragments.NewNoteFragment;
import be.ehb.notedroid.fragments.NoteListFragment;
import be.ehb.notedroid.model.Note;

public class MainActivity extends AppCompatActivity implements NoteListFragmentDelegate {

    private FloatingActionButton fabAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frag_container,NoteListFragment.newInstance()).commit();

        fabAddNote = findViewById(R.id.fab_add);
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, NewNoteFragment.newInstance()).addToBackStack("back").commit();
            }
        });


    }



    @Override
    public void chosenNote(Note n) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, NewNoteFragment.newInstance(n)).addToBackStack("back").commit();
    }
}
