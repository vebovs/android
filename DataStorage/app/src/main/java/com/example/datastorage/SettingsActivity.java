package com.example.datastorage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportActionBar().setTitle("Settings");
        getFragmentManager().beginTransaction().add(R.id.settings, new MyPreference()).commit();
    }
}