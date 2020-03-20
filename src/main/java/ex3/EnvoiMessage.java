package ex3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EnvoiMessage implements Runnable{

    Socket s;

    Boolean stop = false;

    public EnvoiMessage(Socket s) {
        this.s = s;
    }

    public Boolean getStop() {
        return stop;
    }

    public void run() {
        try {
            PrintWriter outs = new PrintWriter( new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream())), true);

            Scanner scanner = new Scanner(System.in);
            String mess;

            do {
                System.out.println("Envoyez un message : ");
                mess = scanner.nextLine();
                outs.println(mess);
            } while (!mess.equals("stop"));

            stop = true;
            outs.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
