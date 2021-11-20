package Server;

import Client.GameStatusPage;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread{
    public static void main(String[]args) throws IOException {

        int portNummer = 12345;
        ServerSocket serverSocket = new ServerSocket(portNummer);

            try {
                while (true) {
                    Player player1 = new Player(serverSocket.accept(), "Player 1");
                    Player player2 = new Player(serverSocket.accept(), "Player 2");
                    Player player3 = new Player(serverSocket.accept(), "Player 3");
                    Player player4 = new Player(serverSocket.accept(), "Player 4");

                    Game newGame = new Game(player1, player2, player3, player4);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void run(){

        }

    }
