package Server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Player implements Runnable {
    String text;

    private int questionCounter;
    private int playerPoints;
    private String currentCategory;
    private boolean hasAnswered;

    private List<String> playersInGame;
    private String name;
    private Socket socket;

    BufferedReader input;
    PrintWriter output;


    public Player(Socket socket, String name){
        this.socket = socket;
        this.name = name;
        this.playersInGame.add(name);
    }

    public void run(){
        Game game = new Game();

    }

    public String waitingForOpponent(){
        text = "Waiting for opponent....";
        return text;
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

    public List<String> getPlayersInGame() {
        return playersInGame;
    }

    public void setPlayersInGame(List<String> playersInGame) {
        this.playersInGame = playersInGame;
    }
}
