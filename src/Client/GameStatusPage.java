package Client;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GameStatusPage extends JPanel implements Runnable{

    Thread aktivitet = new Thread(this);
    JPanel mainPanel = new JPanel();
    JPanel currentPlayers = new JPanel();
    JPanel buttonToPlay = new JPanel();
    JPanel showState = new JPanel();
    JButton play = new JButton("Spela");
    JLabel currentState = new JLabel();
    PrintWriter printWriter;
    CategoryPanel chooseCategory;

    Player player = new Player();

    List<String> amountOfPlayers = new ArrayList<>();
    String name;

    GameStatusPage(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public CategoryPanel getChooseCategory() {
        return this.chooseCategory;
    }

    public void getListOfPlayers(){
        //this.name = player.getName();
        amountOfPlayers.add("One");
        amountOfPlayers.add("Two");
    }

    public JPanel currentGameStatus(){
        mainPanel.setLayout(new BorderLayout());
        currentPlayers.setLayout(new GridLayout(4,1));
        showState.add(currentState);
        mainPanel.add(showState, BorderLayout.NORTH);
        mainPanel.add(currentPlayers, BorderLayout.CENTER);
        mainPanel.add(buttonToPlay, BorderLayout.SOUTH);

        getListOfPlayers();
        aktivitet.start();


        return mainPanel;
    }


    ActionListener playButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == play){
                chooseCategory = new CategoryPanel();
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.add(chooseCategory.categoryPicker());
                //mainPanel.revalidate();
                //mainPanel.repaint();
                printWriter.println("2");
            }
        }
    };


    @Override
    public void run() {
        //currentPlayers.add(new JLabel("Hello"));
        if (amountOfPlayers.size() >= 2) {
            play.addActionListener(playButtonListener);
            buttonToPlay.add(play);
            currentState.setText("Ready to play!");
        } else {
            currentState.setText("Waiting for opponent...");
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

}



