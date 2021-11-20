package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {

    MainMenu menu = new MainMenu();
    QuizPanel panel = new QuizPanel();

    Client(){
        setTitle("Quiz Kampen");
        add(menu.createMenu());
        //add(panel.quizWindow());

        setResizable(false);
        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {

        int portNummer = 8765;
        String hostName = "127.0.0.1";

        try {
            Socket socket = new Socket(hostName, portNummer);
            System.out.println("socket is open in client");
            // from client to server
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            // from server to client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String toServer;
            String fromServer;
            // input in client
            BufferedReader writeInMyText = new BufferedReader(new InputStreamReader(System.in));

            Client c = new Client();

            while(true){
                System.out.println("write something to be sent to server");
                toServer = writeInMyText.readLine();
                printWriter.println(toServer);

                if(toServer.equals("bye")){
                    break;
                }
                fromServer = bufferedReader.readLine();
                System.out.println("the response from Server " + fromServer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        PropertiesHandler propertiesHandler = new PropertiesHandler();
        propertiesHandler.readPropertiesFromPropertyFile();
        String quizNumInRound = propertiesHandler.getProperty("quizNumInRound");
        String roundNum = propertiesHandler.getProperty("roundNum");

        Client client = new Client();

    }
}
