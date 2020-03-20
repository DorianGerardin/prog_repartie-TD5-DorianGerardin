package ex1;

import java.io.*;
import java.net.*;
public class ClientQ5 {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket(args[0],6020);
        System.out.println("SOCKET = " + s);

        BufferedReader ins = new BufferedReader(
                new InputStreamReader(s.getInputStream()) );

        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream())), true);


        for (int i = 0; i < 10; i++) {
            String mess = "message " + i + " ";
            outs.println(mess);
            mess = ins.readLine();
            System.out.println(mess);
        }
        System.out.println("stop");
        outs.println("stop");

        ins.close();
        outs.close();
        s.close();
    }
}