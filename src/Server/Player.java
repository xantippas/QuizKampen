package Server;

import Client.GameStatusPage;
import Client.MainMenu;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread{

    private int questionCounter;
    private int playerPoints=0;
    private String currentCategory;
    private boolean hasAnswered;
    JFrame frame = new JFrame();


    private String name;
    private Socket socket;

    BufferedReader input;
    PrintWriter output;
    GameStatusPage status = new GameStatusPage();

    public Player(Socket socket, String name){
        this.socket = socket;
        this.name = name;
        try{
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("waiting for opponent...");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public String setText(){
        String s = "Waiting for opponent";
        return s;
    }


    @Override
    public void run(){
        /*frame.setTitle("Quiz Kampen");
        //frame.add(menu.createMenu());
        //add(panel.quizWindow());

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        try{
            GameStatusPage status = new GameStatusPage();
            status.currentGameStatus();
            //add all class methods in order of run
        } catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public Socket getSocket() {
        return socket;
    }


    public int getQuestionCounter() {
        return questionCounter;
    }

    public void setQuestionCounter(int questionCounter) {
        this.questionCounter = questionCounter;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }

    public boolean isHasAnswered() {
        return hasAnswered;
    }

    public void setHasAnswered(boolean hasAnswered) {
        this.hasAnswered = hasAnswered;
    }

}
