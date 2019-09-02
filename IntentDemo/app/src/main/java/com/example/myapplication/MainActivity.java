package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numberBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberBox = findViewById(R.id.NumberBox);
    }

    public void onClick(View view){
        Intent i = new Intent("RandomNumber");
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result", 0);
                //String str = String.valueOf(result);
                //Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                numberBox.setText("WINNER: " + result);
            }
            if(resultCode == RESULT_CANCELED){
                numberBox.setText("Got nothing");
            }
        }
    }
}
