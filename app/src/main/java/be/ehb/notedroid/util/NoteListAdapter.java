package be.ehb.notedroid.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteDataSource;
import be.ehb.notedroid.R;

/**
 * Created by Q on 20-2-2018.
 */

public class NoteListAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView tvTitle,tvChangedOn;
    }

    private Activity mContext;
    private ArrayList<Note>items;

    //constructor
    public NoteListAdapter(Activity mContext) {
        this.mContext = mContext;
        items = NoteDataSource.getINSTANCE().getNoteList();
    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder mViewHolder;

        if (view == null){
            view = mContext.getLayoutInflater().inflate(R.layout.row_note,viewGroup,false);
            mViewHolder = new ViewHolder();

            mViewHolder.tvTitle = view.findViewById(R.id.tv_note_title);
            mViewHolder.tvChangedOn = view.findViewById(R.id.tv_note_changed_on);

            view.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) view.getTag();
        }

        Note currentNote = items.get(i);


        Date noteLastChanged = currentNote.getLaatsteWijziging();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault());
        String lastChangedDate = sdf.format(noteLastChanged);



        mViewHolder.tvTitle.setText(currentNote.getTitel());
        mViewHolder.tvChangedOn.setText(lastChangedDate);



        return view;
    }
}
