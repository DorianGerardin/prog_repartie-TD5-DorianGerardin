package ex3;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket(args[0], 6020);
            System.out.println("SOCKET = " + s);

            BufferedReader ins = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            ExecutorService es = Executors.newFixedThreadPool(1);
            EnvoiMessage mess = new EnvoiMessage(s);
            es.execute(mess);

            String messRecu;
            while (!mess.getStop()) {

                messRecu = ins.readLine();
                System.out.println(messRecu);
            }
            ins.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
