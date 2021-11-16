package Server;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int questionCounter;
    private int playerPoints;
    private String currentCategory;
    //boolean hasAnswered; move to Game class?
    private List<Player> playersInGame = new ArrayList<>();

    Player(){
        playersInGame.add(new Player());
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
}
