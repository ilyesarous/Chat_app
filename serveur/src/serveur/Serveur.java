package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class Serveur {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("serveur en attente");
            String name, mesSign, mesLog;
            Signin sign = new Signin();
            
            while (true){
                Socket s = ss.accept();
                System.out.println("client connectee");
                
                //connexion into BD
                System.out.println(sign.connectBD());
                
                InputStream is = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                name = br.readLine();
                
                String[] t = name.split("%");
                System.out.println(t);
                OutputStream os = s.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
//                // insert into database
                if(t.length>2) {
                	mesSign = sign.insertBD(t);
                	System.out.println("mes = "+mesSign);
                	pw.println(mesSign);
                }else {
                	mesLog = sign.login(t);
                	System.out.println("mes login: "+mesLog);
                	pw.println(mesLog);
                }
            	
//           
            	
                
                
//                
                
                
                //pw.println(mesSign);
//                pw.println(mesLog);


                System.out.println("name sent to client");
                s.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
	
}
