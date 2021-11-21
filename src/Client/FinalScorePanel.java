package Client;

import javax.swing.*;
import java.awt.*;

public class FinalScorePanel extends JPanel {

    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel title = new JPanel();
    JPanel scoreBoard = new JPanel();
    JLabel playerOneScore = new JLabel("Player 1\n3");
    JLabel playerTwoScore = new JLabel("Player 2\4");
    JLabel titleText = new JLabel("Total Scores: ");

    public JPanel finalScores(){
        frame.setVisible(true);
        frame.setSize(420,420);
        mainPanel.setLayout(new BorderLayout());


        titleText.setFont(new Font("Montserrat", Font.BOLD, 16));

        title.add(titleText);

        scoreBoard.setLayout(new GridLayout(1,2));
        scoreBoard.add(playerOneScore);
        scoreBoard.add(playerTwoScore);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(scoreBoard, BorderLayout.CENTER);
        frame.add(mainPanel);

        return mainPanel;
    }

    public static void main(String[] args) {
        FinalScorePanel fin = new FinalScorePanel();
        fin.finalScores();
    }
}
