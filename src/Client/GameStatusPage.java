package Client;

import Server.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class GameStatusPage extends JPanel implements Runnable{

    JPanel mainPanel = new JPanel();
    JPanel currentPlayers = new JPanel();
    JPanel buttonToPlay = new JPanel();
    JPanel showState = new JPanel();
    JButton play = new JButton("Spela");
    JLabel currentState = new JLabel();
    Player player = new Player();

    List<String> amountOfPlayers = new ArrayList<>();
    String name;

    public GameStatusPage(){

    }

    public JPanel currentGameStatus(){
        mainPanel.setLayout(new BorderLayout());
        currentPlayers.setLayout(new GridLayout(4,1));
        currentPlayers.setBorder(new LineBorder(Color.BLACK));
        showState.add(currentState);
        mainPanel.add(showState, BorderLayout.NORTH);
        mainPanel.add(currentPlayers, BorderLayout.CENTER);
        mainPanel.add(buttonToPlay, BorderLayout.SOUTH);

        amountOfPlayers.add("hello");
        run();

        return mainPanel;
    }


    ActionListener playButtonListener = e -> {
        if (e.getSource() == play){
            CategoryPanel chooseCategory = new CategoryPanel();
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            mainPanel.add(chooseCategory.categoryPicker());
        }
    };


    @Override
    public void run() {
            //System.out.println(amountOfPlayers);
        //player.run();
        currentState.add(player.sendState());
            /*currentPlayers.add(new JLabel("Hello"));
            if (this.amountOfPlayers.size() >= 2) {
                play.addActionListener(playButtonListener);
                buttonToPlay.add(play);
                currentState.setText("Ready to play!");
            } else {
                currentState.setText("Waiting for opponent...");
            }*/
            mainPanel.revalidate();
            mainPanel.repaint();
    }

}



