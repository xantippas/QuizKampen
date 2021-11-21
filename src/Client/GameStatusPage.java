package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameStatusPage extends JPanel{

    JPanel mainPanel = new JPanel();
    JPanel currentPlayers = new JPanel();
    JPanel buttonToPlay = new JPanel();
    JPanel showState = new JPanel();
    JButton play = new JButton("Spela");
    public JLabel currentState = new JLabel();

    public JPanel currentGameStatus(){
        mainPanel.setLayout(new BorderLayout());
        currentPlayers.setLayout(new GridLayout(4,1));
        showState.add(currentState);
        mainPanel.add(showState, BorderLayout.NORTH);
        mainPanel.add(currentPlayers, BorderLayout.CENTER);
        mainPanel.add(buttonToPlay, BorderLayout.SOUTH);

        currentState.setText("Ready to play!");
        play.addActionListener(playButtonListener);
        buttonToPlay.add(play);


        /*if (amountOfPlayers.size() >= 2) {
            play.addActionListener(playButtonListener);
            buttonToPlay.add(play);
            currentState.setText("Ready to play!");
        } else {
            currentState.setText("Waiting for opponent...");
        }*/

        return mainPanel;
    }


    ActionListener playButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == play){
                CategoryPanel chooseCategory = new CategoryPanel();
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.add(chooseCategory.categoryPicker());

            }
        }
    };

}



