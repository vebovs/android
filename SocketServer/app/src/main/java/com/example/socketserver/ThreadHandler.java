package com.example.socketserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler extends Thread {
    Socket s;
    PrintWriter out;
    BufferedReader in;

    public ThreadHandler(Socket s){
        this.s = s;
    }

    public void run(){
        try {
            out = new PrintWriter(this.s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            out.println("Server started");
            String str = in.readLine();
            System.out.println(str);
            String a = in.readLine();
            String b = in.readLine();
            while(a != null || b != null){
                out.println(Integer.parseInt(a) + Integer.parseInt(b));
                a = in.readLine();
                b = in.readLine();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
