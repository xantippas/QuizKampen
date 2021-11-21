package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {

    // experiment purpose
    Socket socket;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    int portNummer = 8765;
    String hostName = "127.0.0.1";

    //ClientSocket clientSocket = new ClientSocket();;
    MainMenu menu;
    QuizPanel panel = new QuizPanel();

    Client() {
        try {
            this.socket = new Socket(hostName, portNummer);
            System.out.println("socket is open in client");
            // from client to server
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            // from server to client
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        menu = new MainMenu(socket, printWriter, bufferedReader);
        setTitle("Quiz Kampen");
        add(menu.createMenu());
        //add(panel.quizWindow());
        setResizable(false);
        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // clientSocket.startConnection();
        startConnection();

    }

    public void startConnection() {
        try {
            String line;
            while(true) {
                line = bufferedReader.readLine();
                System.out.println("the response from Server " + line);
                char code = line.charAt(0);
                System.out.println("code from server is " + code);
                switch (code) {
                    case '1':
                        System.out.println(line);
                        break;
                    case '2':
                        String[] extractedCategories = line.substring(3, line.length()-1).split(",");
                        menu.getGameStatusPage().getChooseCategory().getCategoryHistory().setText(extractedCategories[3]);
                        break;
                    default:
                        System.out.println("To be implemented");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Client client = new Client();

    }
}
