package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {

    MainMenu menu = new MainMenu();
    //Thread thread = new Thread(this);

    Client(){
        setTitle("Quiz Kampen");
        add(menu.createMenu());

        setResizable(false);
        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {

        int portNummer = 12345;
        String hostName = "192.168.0.101";

        try {
            Socket socket = new Socket(hostName, portNummer);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String toServer;
            String fromServer;
            BufferedReader writeInMyText = new BufferedReader(new InputStreamReader(System.in));

            Client c = new Client();

            while((fromServer = writeInMyText.readLine()) != null){
                System.out.println("Server " + fromServer);

                toServer = writeInMyText.readLine();
                if (writeInMyText != null) {
                    out.println(toServer);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
