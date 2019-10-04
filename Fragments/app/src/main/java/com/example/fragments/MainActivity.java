package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {
    private TitleViewer tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTitles();
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showTitles(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        tv = (TitleViewer) fm.findFragmentById(R.id.title_viewer);
        ft.show(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if(i == R.id.menu_next){
            tv.show(1);
            return true;
        } else if(i == R.id.menu_last){
            tv.show(-1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
