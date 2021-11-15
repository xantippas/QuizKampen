package Client;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Client extends JFrame {

    //private quizQuestions quizQuestions;
    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel question = new JLabel();

    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();
    JButton choices;

    Client(){
        mainPanel.setLayout(new GridLayout(2, 1));
        topPanel.add(question);
        //getQuestions();
        centerPanel.setLayout(new GridLayout(2,2));

      //  setButtonText();

        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);

        add(mainPanel);

        setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    /*public JLabel getQuestions(){
        quizQuestions q = new quizQuestions();
        String question1 = Arrays.toString(q.getQuestions());
        question.setText(question1);
        return question;
    }

    public JPanel setButtonText(){
        quizQuestions q = new quizQuestions();
        String[] answer = q.getAnswers();
        for (int i = 0; i < answer.length ; i++) {
            String text = answer[i];
            choices = new JButton(text);
            centerPanel.add(choices);
        }

        return centerPanel;


    } */




    public static void main(String[] args) {

        int portNummer = 12345;
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
        }

    }
}
