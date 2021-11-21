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

    public Client(){
        int portNummer = 8765;
        String hostName = "192.168.0.101";
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

                //Client c = new Client();

                //while(true){
                /*c.frame.setResizable(false);
                c.frame.setVisible(true);
                c.frame.setSize(420,420);
                c.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                c.frame.setLocationRelativeTo(null);*/

                /*System.out.println("write something to be sent to server");
                toServer = writeInMyText.readLine();
                printWriter.println(toServer);

                if(toServer.equals("bye")){
                    break;
                }*/
                while (true){
                    if ((fromServer = bufferedReader.readLine()) != null) {
                        System.out.println("the response from Server " + fromServer);
                    }
                }



                //}

            } catch (Exception e) {
                e.printStackTrace();
            }

        /*setTitle("Quiz Kampen");
        add(menu.createMenu());
        //add(panel.quizWindow());

        setResizable(false);
        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);*/

    }

    public void play(){
        add(menu.createMenu());
    }


    public static void main(String[] args) {
            Client c = new Client();
            c.setResizable(false);
            c.setVisible(true);
            c.setSize(420,420);
            c.setDefaultCloseOperation(EXIT_ON_CLOSE);
            c.setLocationRelativeTo(null);
            c.play();
    }
}
