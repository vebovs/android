package com.example.socket;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private final static String IP = "10.0.2.2";
    private final static int PORT = 12345;
    private Activity activity;
    EditText etA;
    EditText etB;
    TextView tv;
    Button btn;
    PrintWriter out;
    BufferedReader in;
    Socket s;

    public Client(Activity activity){
        this.activity = activity;
    }

    public void run() {
        etA = this.activity.findViewById(R.id.inputA);
        etB = this.activity.findViewById(R.id.inputB);
        tv = this.activity.findViewById(R.id.output);

        try {
            s = new Socket(IP, PORT);
            System.out.println("Connected to server: " + s.toString());
            out = new PrintWriter(s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String str = in.readLine();
            System.out.println(str);
            out.println("PING to server from client");

            btn = this.activity.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String a = etA.getText().toString();
                        String b = etB.getText().toString();
                        out.println(a);
                        out.println(b);
                        String response = in.readLine();
                        tv.setText(response);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}