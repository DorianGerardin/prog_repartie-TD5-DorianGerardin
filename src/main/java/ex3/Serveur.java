package ex3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serveur {

    public static void main(String[] args) throws Exception {

        ArrayList<Connexion> connexions = new ArrayList<Connexion>();

        ExecutorService es = Executors.newFixedThreadPool(3);

        ServerSocket s = new ServerSocket(6020);

        System.out.println("START");
        try {
            while (true) {
                Socket soc = s.accept();
                Connexion connexion = new Connexion(soc, connexions);
                connexions.add(connexion);
                es.execute(connexion);
            }
        } finally {
            s.close();
        }
    }
}
