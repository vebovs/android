package com.example.datastorage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private DatabaseManager db;
    private TextView tv;
    SharedPreferences.OnSharedPreferenceChangeListener spChanged = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            String str = sharedPreferences.getString(s, "-1");
            tv = findViewById(R.id.tw1);
            if(str.equals("Blue")){
                tv.setHighlightColor(Color.BLUE);
                tv.setBackgroundColor(tv.getHighlightColor());
            } else if(str.equals("Green")){
                tv.setHighlightColor(Color.GREEN);
                tv.setBackgroundColor(tv.getHighlightColor());
            } else if(str.equals("Red")){
                tv.setHighlightColor(Color.RED);
                tv.setBackgroundColor(tv.getHighlightColor());
            } else if(str.equals("White")){
                tv.setHighlightColor(Color.WHITE);
                tv.setBackgroundColor(tv.getHighlightColor());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String str = sharedPreferences.getString("color", "-1");
        tv = findViewById(R.id.tw1);
        if(str.equals("Blue")){
            tv.setHighlightColor(Color.BLUE);
            tv.setBackgroundColor(tv.getHighlightColor());
        } else if(str.equals("Green")){
            tv.setHighlightColor(Color.GREEN);
            tv.setBackgroundColor(tv.getHighlightColor());
        } else if(str.equals("Red")){
            tv.setHighlightColor(Color.RED);
            tv.setBackgroundColor(tv.getHighlightColor());
        } else if(str.equals("White")){
            tv.setHighlightColor(Color.WHITE);
            tv.setBackgroundColor(tv.getHighlightColor());
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(spChanged);

        InputStream in = getResources().openRawResource(R.raw.example);
        BufferedReader bufferedReader = null;
        try {
            db = new DatabaseManager(this);
            db.clean();
            in = getResources().openRawResource(R.raw.example);
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line;
            String[] data;
            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                db.insert(data[0], data[1]);
            }
            ArrayList<String> result = db.getAllBooks();
            showResults(result);
        } catch (Exception e){
            e.printStackTrace();
            tv = findViewById(R.id.tw1);
            tv.setText(e.getMessage());
        } finally {
            try {
                in.close();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showResults(ArrayList<String> list) {
        StringBuffer res = new StringBuffer("");
        for (String s : list)  {
            res.append(s+"\n");
        }
        TextView t = (TextView)findViewById(R.id.tw1);
        t.setText(res);
    }

    public void showBooks(View view){
        ArrayList<String> result = db.getAllBooks();
        showResults(result);
    }

    public void showAuthors(View view){
        ArrayList<String> result = db.getAllAuthors();
        showResults(result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        tv = findViewById(R.id.tw1);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
