package Server;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int questionCounter;
    private int playerPoints;
    private String currentCategory;
    private boolean hasAnswered;
    private List<String> playersInGame = new ArrayList<>();
    String name;


    public void setPlayer(String name){
        this.name = name;
        this.playersInGame.add(name);
        System.out.println(playersInGame.toString());
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

    public String getName() {
        return name;
    }
}
