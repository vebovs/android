package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Random;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent i = getIntent();
        int number = number();
        if(number == 100){
            Intent result = new Intent();
            result.putExtra("result", number);
            setResult(RESULT_OK, result);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }

    private int number(){
        Random r = new Random();
        int lower_bounds = 0;
        int upper_bounds = 100;
        return r.nextInt(upper_bounds) + lower_bounds;
    }
}
