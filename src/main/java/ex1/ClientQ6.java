package ex1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientQ6 {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket(args[0],6020);
        System.out.println("SOCKET = " + s);

        BufferedReader ins = new BufferedReader(
                new InputStreamReader(s.getInputStream()) );

        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream())), true);

        Scanner scanner = new Scanner(System.in);

        String mess;
        String messRecu;
        do {
            System.out.println("Envoyez un message : ");
            mess = scanner.nextLine();

            outs.println(mess);
            messRecu = ins.readLine();
            System.out.println(messRecu);

        } while (!mess.equals("stop"));

        ins.close();
        outs.close();
        s.close();
    }
}