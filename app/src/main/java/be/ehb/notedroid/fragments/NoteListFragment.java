package be.ehb.notedroid.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import be.ehb.notedroid.model.NoteDataSource;
import be.ehb.notedroid.util.NoteListFragmentDelegate;
import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.util.NoteListAdapter;
import be.ehb.notedroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private ListView lvNotes;
    private NoteListAdapter mNoteListAdapter;
    private NoteListFragmentDelegate delegate;


    public NoteListFragment() {
        // Required empty public constructor
    }

    public static NoteListFragment newInstance(){
        return new NoteListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        delegate = (NoteListFragmentDelegate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_note_list,container,false);

        lvNotes = rootView.findViewById(R.id.lv_notes);
        mNoteListAdapter = new NoteListAdapter(getActivity());
        lvNotes.setAdapter(mNoteListAdapter);

        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note selectedNote = (Note) mNoteListAdapter.getItem(i);

                delegate.chosenNote(selectedNote);

            }
        });

        registerForContextMenu(lvNotes);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getActivity().getMenuInflater().inflate(R.menu.note_list_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Note toBeDeleted = (Note) mNoteListAdapter.getItem(info.position);
        NoteDataSource.getINSTANCE().deleteNote(toBeDeleted);


        mNoteListAdapter.notifyDataSetChanged();

        return super.onContextItemSelected(item);
    }
}
