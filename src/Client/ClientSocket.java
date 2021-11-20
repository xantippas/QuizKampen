package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    Socket socket;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    BufferedReader writeInMyText;
    String fromServer;
    int portNummer = 8765;
    String hostName = "127.0.0.1";

    public ClientSocket () {
        try {
            this.socket = new Socket(hostName, portNummer);
            System.out.println("socket is open in client");
            // from client to server
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            // from server to client
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // input in client (this can be deleted afterwards
            // because this BufferReader below accepts input
            // only from console)
            this.writeInMyText = new BufferedReader(new InputStreamReader(System.in));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startConnection() {
        try {
            while(true) {
                fromServer = bufferedReader.readLine();
                System.out.println("the response from Server " + fromServer);
            }
        }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void sendDataToServer (String input) {
        printWriter.println(input);
    }
}
