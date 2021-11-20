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
    ClientSocket clientSocket = new ClientSocket();;
    MainMenu menu = new MainMenu(clientSocket);
    QuizPanel panel = new QuizPanel();


    Client() {
        setTitle("Quiz Kampen");
        add(menu.createMenu());
        //add(panel.quizWindow());
        setResizable(false);
        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        clientSocket.startConnection();
    }


    public static void main(String[] args) {

        Client client = new Client();

    }
}
