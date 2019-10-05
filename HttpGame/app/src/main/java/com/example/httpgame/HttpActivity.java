package com.example.httpgame;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HttpActivity extends Activity {
    private HttpWrapperThreaded network;
    final static String TAG = "HttpActivity";
    final static String urlToServer = "http://tomcat.stud.iie.ntnu.no/studtomas/tallspill.jsp";
    EditText etName;
    EditText etCard;
    EditText etNumber;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Log.w(TAG, "Contacting server...");
        network = new HttpWrapperThreaded(this, urlToServer);
        etName = findViewById(R.id.inputName);
        etCard = findViewById(R.id.inputCard);
        etNumber = findViewById(R.id.inputNumber);
        tv = findViewById(R.id.placeholder);
    }

    public void showResponse(String response) {
        tv.setText(response);
        Log.w(TAG, "Server responded with: " + response);
        Toast.makeText(getBaseContext(), "Look in log for response!!!", Toast.LENGTH_LONG).show();
    }

    private Map<String, String> createRequestValues(String name, String card) {
        Map<String, String> valueList = new HashMap<>();
        valueList.put("navn", name);
        valueList.put("kortnummer", card);
        return valueList;
    }

    public void sendData(View view){
        String name = etName.getText().toString();
        String card = etCard.getText().toString();
        network.runHttpRequestInThread(HttpWrapperThreaded.HttpRequestType.HTTP_GET, createRequestValues(name, card));
    }

    public void sendNumber(View view){
        String number = etNumber.getText().toString();
        Map<String, String> valueList = new HashMap<>();
        valueList.put("tall", number);
        network.runHttpRequestInThread(HttpWrapperThreaded.HttpRequestType.HTTP_GET, valueList);
    }
}