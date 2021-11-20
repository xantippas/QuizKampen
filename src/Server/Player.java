package Server;

import Client.GameStatusPage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable{
    private int questionCounter;
    private int playerPoints;
    private String currentCategory;
    private boolean hasAnswered;
    String name;
    Socket socket;
    List<String> listOf = new ArrayList<>();

    //testing
    JLabel currentState = new JLabel();

    public Player(){

    }

    public Player(Socket socket, String name){
        this.socket = socket;
        this.name = name;
        this.listOf.add(name);
    }

    public List<String> getListOf() {
        return listOf;
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

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public JLabel sendState(){
        if (this.listOf.size() >= 2){
            currentState.setText("Ready to Play");
        } else {
            currentState.setText("Waiting for opponent...");
        }

        return currentState;
    }

    @Override
    public void run() {
        try{
            /*PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/

            sendState();

            //currentPlayers.add(new JLabel("Hello"));
            /*if (this.listOf.size() >= 2) {
                play.addActionListener(playButtonListener);
                buttonToPlay.add(play);
                currentState.setText("Ready to play!");
            } else {
                currentState.setText("Waiting for opponent...");
            }
            mainPanel.revalidate();
            mainPanel.repaint();*/
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
