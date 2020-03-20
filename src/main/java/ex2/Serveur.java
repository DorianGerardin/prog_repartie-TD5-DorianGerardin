package ex2;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serveur {

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(3);

        ServerSocket s = new ServerSocket(6020);

        System.out.println("START");
        try {
            while (true) {
                Socket soc = s.accept();
                Connexion connexion = new Connexion(soc);
                es.execute(connexion);
            }
        } finally {
            s.close();
        }
    }
}
