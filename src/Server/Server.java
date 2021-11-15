package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args) throws IOException {
        int portNummer = 12345;
        ServerSocket serverSocket = new ServerSocket(portNummer);

        while (true) {

            try (
                    Socket socket = serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

                String toClient;
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                while ((toClient = in.readLine()) != null) {
                    printWriter.println(toClient);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
