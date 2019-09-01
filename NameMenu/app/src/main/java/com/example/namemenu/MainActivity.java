package com.example.namemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String firstname = "First name";
    String lastname = "Last name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstnametext = findViewById(R.id.FirstnameText);
        final EditText lastnametext = findViewById(R.id.LastnameText);
        final Button firstnamebtn = findViewById(R.id.FirstnameBtn);
        final Button lastnamebtn = findViewById(R.id.LastnameBtn);

        firstnamebtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname = firstnametext.getText().toString();
            }
        });

        lastnamebtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                lastname = lastnametext.getText().toString();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(firstname);
        menu.add(lastname);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getTitle().equals("First name")){
            Log.i("onOptionsItemSelected()", firstname  + " was clicked by user");
        } else {
            Log.i("onOptionsItemSelected()",lastname + " was clicked by user");
        }

        return true;
    }
}
