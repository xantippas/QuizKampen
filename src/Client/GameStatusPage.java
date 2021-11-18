package Client;

import javax.swing.*;
import java.awt.*;

public class GameStatusPage extends JPanel{

    JPanel mainPanel = new JPanel();
    JPanel currentPlayers = new JPanel();
    JPanel buttonToPlay = new JPanel();
    JPanel showState = new JPanel();
    JButton play = new JButton("Spela");
    JLabel currentState = new JLabel();

    //player class create List<Player> amountOfPlayers = new ArrayList<>();


    public GameStatusPage currentGameStatus(){
        mainPanel.setLayout(new BorderLayout());
        currentPlayers.setLayout(new GridLayout(4,1));
        showState.add(currentState);
        mainPanel.add(showState, BorderLayout.NORTH);
        mainPanel.add(currentPlayers, BorderLayout.CENTER);
        mainPanel.add(buttonToPlay, BorderLayout.SOUTH);

        if (false){
            /*currentPlayers.add(new String("Player 1"));
            currentPlayers.add(new String("Player 2"));
            currentPlayers.add(new String("Player 3"));
            currentPlayers.add(new JButton("Player 4"));*/
            //amountOfPlayers.size() >= 2
            buttonToPlay.add(play);
            currentState.setText("Ready to play!");

        } else {
            currentState.setText("Waiting for opponent...");
        }

        return this;
    }




}
