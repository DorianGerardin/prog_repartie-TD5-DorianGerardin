package ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Connexion implements Runnable{

    private Socket socket;

    public Connexion(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            BufferedReader ins = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()) );
            PrintWriter outs = new PrintWriter( new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);

            while (true) {
                String messRecu = ins.readLine();
                System.out.println("Reçu : " + messRecu);
                if (messRecu.equals("stop")) {
                    outs.println("Reçu : stop");
                    break;
                }
                outs.println("Reçu : " + messRecu);
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
