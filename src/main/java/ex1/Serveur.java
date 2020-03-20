package ex1;

import java.io.*;
import java.net.*;
public class Serveur {

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(6020);
        System.out.println("START");
        Socket soc = s.accept();
        BufferedReader ins = new BufferedReader(
                new InputStreamReader(soc.getInputStream()) );
        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(soc.getOutputStream())), true);

        // insertion de la boucle du serveur ici
        while (true) {
            String messRecu = ins.readLine();
            System.out.println("Reçu : " + messRecu);
            if (messRecu.equals("stop")) {
                outs.println("Reçu : stop");
                break;
            }
            outs.println("Reçu : " + messRecu);
        }

        ins.close();
        outs.close();
        soc.close();
    }
}
