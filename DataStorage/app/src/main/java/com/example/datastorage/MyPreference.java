package com.example.datastorage;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class MyPreference extends PreferenceFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
