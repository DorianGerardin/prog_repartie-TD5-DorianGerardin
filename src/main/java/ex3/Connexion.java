package ex3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Connexion implements Runnable{

    private Socket socket;

    ArrayList<Connexion> connexions;

    PrintWriter outs;

    public Connexion(Socket socket, ArrayList<Connexion> connexions) {

        this.socket = socket;
        this.connexions = connexions;
        try {
            this.outs = new PrintWriter( new BufferedWriter(
                    new OutputStreamWriter(this.socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            BufferedReader ins = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()) );

            while (true) {
                String messRecu = ins.readLine();
                System.out.println("Reçu : " + messRecu);
                if (messRecu.equals("stop")) {
                    outs.println("Reçu : stop");
                    break;
                }
                for (Connexion c: this.connexions) {
                    c.outs.println("Reçu : " + messRecu);
                }

            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
