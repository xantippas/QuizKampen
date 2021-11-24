import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class FinalScoreBoardPanel extends JPanel {

    int totalScore = 0;
    int secondTotal = 0;
    String totalScorePlayerOne;
    String totalScorePlayerTwo;
    JPanel mainPanel = new JPanel();
    JPanel panell = new JPanel();
    JLabel titleOfWindow = new JLabel("Game finished, Final scores!");
    JLabel titleOfRoundOne = new JLabel("Round 1 scores");
    JLabel titleOfRoundTwo = new JLabel("Round 2 scores");
    JLabel titleOne = new JLabel("PLayer 1");
    JLabel titleTwo = new JLabel("Player 2");
    JLabel scoreOne = new JLabel();
    JLabel scoreTwo = new JLabel();

    JLabel winnerOfGame = new JLabel();

    public FinalScoreBoardPanel(List<Integer> scores){
        panell.setLayout(new BorderLayout());

        titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));

        mainPanel.setLayout(new GridLayout(5,2,5,5));
        mainPanel.setPreferredSize(new Dimension(200,200));
        mainPanel.setBorder(new LineBorder(Color.BLACK));
        mainPanel.setBackground(Color.white);

        titleOne.setText("Player 1");
        titleTwo.setText("Player 2");
        titleOne.setFont(new Font("Montserrat", Font.PLAIN, 12));
        titleTwo.setFont(new Font("Montserrat", Font.PLAIN, 12));
        mainPanel.add(titleOne);
        mainPanel.add(titleTwo);

        for (Integer i:scores) {
            mainPanel.add(new JLabel(i.toString()));
        }

        totalScore = scores.get(0) + scores.get(2);
        totalScorePlayerOne = Integer.toString(totalScore);

        secondTotal = scores.get(1) + scores.get(3);
        totalScorePlayerTwo = Integer.toString(secondTotal);

        scoreOne.setText(totalScorePlayerOne);
        scoreTwo.setText(totalScorePlayerTwo);

        mainPanel.add(scoreOne);
        mainPanel.add(scoreTwo);

        if (totalScore > secondTotal){
            winnerOfGame.setText("Player 1 is the winner!");
        } else {
            winnerOfGame.setText("Player 2 is the winner!");
        }

        panell.add(titleOfWindow, BorderLayout.NORTH);
        panell.add(mainPanel, BorderLayout.CENTER);
        panell.add(winnerOfGame, BorderLayout.SOUTH);
        add(panell);
    }
}

