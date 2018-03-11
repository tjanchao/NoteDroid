package be.ehb.notedroid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteDataSource;
import be.ehb.notedroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewNoteFragment extends Fragment {

    private EditText etTitle, etNote;
    private TextView tvCreated, tvChanged;
    private Button btnSave;
    private Note n;
    private boolean isNew = true;


    public NewNoteFragment() {
        // Required empty public constructor
    }

    //factory-methode
    public static NewNoteFragment newInstance() {
        return new NewNoteFragment();
    }

    public static Fragment newInstance(Note n) {
        NewNoteFragment nf = new NewNoteFragment();

        Bundle data = new Bundle();
        data.putSerializable("note", n);
        nf.setArguments(data);

        nf.isNew = false;


        return nf;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_note, container, false);
        etTitle = rootView.findViewById(R.id.et_title);
        etNote = rootView.findViewById(R.id.et_note);
        tvCreated = rootView.findViewById(R.id.tv_created_on);
        tvChanged = rootView.findViewById(R.id.tv_changed_on);
        btnSave = rootView.findViewById(R.id.btn_save);

        if (getArguments() != null) {
            n = (Note) getArguments().getSerializable("note");
            etTitle.setText(n.getTitel());
            etNote.setText(n.getInhoud());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault());


            tvCreated.setText(sdf.format(n.getAanmaakDatum()));
            tvChanged.setText(sdf.format(n.getLaatsteWijziging()));


        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String note = etNote.getText().toString();




                if (isNew) {
                    Note mNote = new Note(title, note);
                    NoteDataSource.getINSTANCE().insertNote(mNote);
                } else {
                    n.setTitel(title);
                    n.setInhoud(note);
                    NoteDataSource.getINSTANCE().updateNote(n);
                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }


}
