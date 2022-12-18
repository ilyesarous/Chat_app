package com.example.chatapp.module;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class MyThread implements Runnable{
    private String mesEnvoyer, mesRecue;

    Socket s;

    @Override
    public void run() {
        try {
            s = new Socket("192.168.31.1", 1234);
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(mesEnvoyer);
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            mesRecue = br.readLine();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String mesEnvoyer){
        this.mesEnvoyer = mesEnvoyer;
        run();
    }
    public String getName(){
        return mesRecue;
    }

}

