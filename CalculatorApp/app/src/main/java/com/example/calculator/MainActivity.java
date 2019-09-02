package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private TextView number1;
    private TextView number2;
    private EditText submittedAnswer;
    private EditText upperBoundry;
    int num1;
    int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMultiply(View view){
        number1 = findViewById(R.id.Number1);
        String str1 = number1.getText().toString();
        num1 = Integer.parseInt(str1);
        number2 = findViewById(R.id.Number2);
        String str2 = number2.getText().toString();
        num2 = Integer.parseInt(str2);

        int result = num1 * num2;

        submittedAnswer = findViewById(R.id.submitAnswerBox);
        String strAnswer = submittedAnswer.getText().toString();
        int answer = Integer.parseInt(strAnswer);

        if(answer == result){
            String message = getText(R.string.correct).toString();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            String message = getText(R.string.wrong).toString();
            message += " " + result;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        Scramble();
    }

    public void onClickAddition(View view){
        number1 = findViewById(R.id.Number1);
        String str1 = number1.getText().toString();
        num1 = Integer.parseInt(str1);
        number2 = findViewById(R.id.Number2);
        String str2 = number2.getText().toString();
        num2 = Integer.parseInt(str2);

        int result = num1 + num2;

        submittedAnswer = findViewById(R.id.submitAnswerBox);
        String strAnswer = submittedAnswer.getText().toString();
        int answer = Integer.parseInt(strAnswer);

        if(answer == result){
            String message = getText(R.string.correct).toString();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            String message = getText(R.string.wrong).toString();
            message += " " + result;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        Scramble();
    }

    public void Scramble(){
        upperBoundry = findViewById(R.id.upperBoundryBox);
        int limit = Integer.parseInt(upperBoundry.getText().toString());
        Intent i = new Intent("RandomNumber");
        i.putExtra("limit", limit);
        startActivityForResult(i, 1);
        startActivityForResult(i, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            num1 = data.getIntExtra("result", 0);
            number1.setText(String.valueOf(num1));
        } else if(requestCode == 2 && resultCode == RESULT_OK){
            num2 = data.getIntExtra("result", 0);
            number2.setText(String.valueOf(num2));
        }
    }
}
