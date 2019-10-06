package com.example.socketserver;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private final int PORT = 12345;

    public void run() {
        ServerSocket ss = null;
        Socket s = null;

        try {
            System.out.println("Started server...");
            ss = new ServerSocket(PORT);
            while(true){
                s = ss.accept();
                Thread threadHandler = new ThreadHandler(s);
                threadHandler.start();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                ss.close();
                s.close();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
