package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {

    MainMenu menu = new MainMenu();
    JPanel mainPanel = new JPanel(new GridLayout(1,1));
    String fromServer;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JLabel statusMessage;
    public boolean state=false;
    GameStatusPage status = new GameStatusPage();

    public Client(String hostName){
        int portNummer = 8765;
        //String hostName = "192.168.0.101";
            try {
                Socket socket = new Socket(hostName, portNummer);
                System.out.println("socket is open in client");
                // from client to server
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                // from server to client
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String toServer;

                // input in client
                //BufferedReader writeInMyText = new BufferedReader(new InputStreamReader(System.in));

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



                //}

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void play() throws IOException {
        mainPanel.add(menu.createMenu());
        while (true){
            if ((fromServer = bufferedReader.readLine()) != null) {
                System.out.println("the response from Server " + fromServer);
            }
        }


    }


    public static void main(String[] args) throws IOException {
            String hostName = "192.168.0.101";
            Client c = new Client(hostName);
            c.add(c.mainPanel);
            c.setResizable(false);
            c.setVisible(true);
            c.setSize(420,420);
            c.setDefaultCloseOperation(EXIT_ON_CLOSE);
            c.setLocationRelativeTo(null);
            c.play();
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
