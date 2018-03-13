package be.ehb.notedroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import be.ehb.notedroid.R;
import be.ehb.notedroid.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getFragmentManager().beginTransaction().add(R.id.settings_container, SettingsFragment.newInstance()).commit();

    }
}
