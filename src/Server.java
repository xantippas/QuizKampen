import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 12345;
        ServerSocket clientSocket = new ServerSocket(portNumber);
        try{
            while(true){
                Socket client1 = clientSocket.accept();
                Socket client2 = clientSocket.accept();

                Game newGame = new Game(client1, client2);
                newGame.start();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
