package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Random;

public class OtherActivity extends AppCompatActivity {
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent i = getIntent();
        int limit = i.getIntExtra("limit", 0);
        int number = number(limit);
        Intent result = new Intent();
        result.putExtra("result", number);
        setResult(RESULT_OK, result);
        finish();
    }

    private int number(int upper_bounds){
        return r.nextInt(upper_bounds);
    }
}