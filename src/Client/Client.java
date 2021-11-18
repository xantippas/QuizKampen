package Client;

import javax.swing.*;

public class Client extends JFrame {

    MainMenu menu = new MainMenu();
    CategoryPanel categoryPanel = new CategoryPanel();
    QuizPanel quizPanel = new QuizPanel();

    Client(){

        add(quizPanel.quizWindow());
      //  add(menu.createMenu());

        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {

        /*int portNummer = 12345;
        String hostName = "172.20.208.134";

        try {
            Socket socket = new Socket(hostName, portNummer);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String toServer;
            String fromServer;
            BufferedReader writeInMyText = new BufferedReader(new InputStreamReader(System.in));

            Client c = new Client();

            while((fromServer = writeInMyText.readLine()) != null){
                System.out.println("Server " + fromServer);

                toServer = writeInMyText.readLine();
                if (writeInMyText != null) {
                    printWriter.println(toServer);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Client client = new Client();

    }
}
