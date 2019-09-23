package com.example.friends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Friend[] friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.friends[0] = new Friend("Jim", "01/01/2000");
        this.friends[1] = new Friend("Bill", "02/02/2000");
        this.friends[2] = new Friend("Kim", "03/03/2000");
        this.friends[3] = new Friend("Bob", "04/04/2000");

        initSpinner();
    }

    private void showFriend(int i){
        TextView tv = (TextView) findViewById(R.id.viewDetails);
        tv.setText(this.friends[i].getName());
    }

    private void initSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new FriendAdapter(this, this.friends));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                showFriend(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //TODO
            }
        });
    }
}
