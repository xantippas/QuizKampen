package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    public static void main(String[]args) throws IOException {
        List<Player> playerList = new ArrayList<>();
        Game game;
        Questions questions = new Questions();
        int portNummer = 8765;
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", portNummer));

        try (
                Socket socket = serverSocket.accept();
                // from server to client
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                // from client to server
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
            System.out.println("socket is open in server");
                    String fromClient;
                    while (true) {
                        fromClient = bufferedReader.readLine();
                        try{
                            int num = Integer.parseInt(fromClient);

                            switch (num) {
                                case 1:
                                    printWriter.println("1");
                                    game = new Game();
                                    break;
                                case 2:
                                    List<String> categories = questions.getCategory();
                                    printWriter.println("2:" + Arrays.toString(categories.toArray()));
                                    break;
                                default:
                                    printWriter.println("server get unregistered number from client");
                            }
                        }catch(NumberFormatException e){
                            printWriter.println("should be a number");
                        }
                        if(fromClient.equals("bye")) {
                            break;
                        }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }
