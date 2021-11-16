package Client;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Client extends JFrame {

    //private quizQuestions quizQuestions;


    MainMenu menu = new MainMenu();
    GameStatusPage gameStatus = new GameStatusPage();

    Client(){


        add(menu.createMenu());
        //add(gameStatus.currentGameStatus());

        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {

        /*int portNummer = 12345;
        String hostName = "172.20.208.134";

        try {
            Socket socket = new Socket(hostName, portNummer);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String toServer;
            String fromServer;
            BufferedReader writeInMyText = new BufferedReader(new InputStreamReader(System.in));

            Client c = new Client();

            while((fromServer = writeInMyText.readLine()) != null){
                System.out.println("Server " + fromServer);

                toServer = writeInMyText.readLine();
                if (writeInMyText != null) {
                    printWriter.println(toServer);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Client client = new Client();
        //GameStatusPage gameStatus = new GameStatusPage();

    }
}
