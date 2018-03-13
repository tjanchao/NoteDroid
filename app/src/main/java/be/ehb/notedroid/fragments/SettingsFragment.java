package be.ehb.notedroid.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import be.ehb.notedroid.R;

/**
 * Created by Q on 11-3-2018.
 */

public class SettingsFragment extends PreferenceFragment {

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance(){
        return new SettingsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_screen);
    }
}
