import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class FinalScoreBoardPanel extends JPanel {

    int playerOneScore = 0;
    int playerTwoScore = 0;

    String totalScorePlayerOne;
    String totalScorePlayerTwo;

    JPanel layoutPanel = new JPanel();
    JPanel mainPanel = new JPanel();

    JLabel titleOfWindow = new JLabel("Matchen avslutad, slutresultat!");
    JLabel totalTitle = new JLabel("TOTAL");
    JLabel emptyFiller = new JLabel(" ");
    JLabel titleOne = new JLabel("Player 1", SwingConstants.CENTER);
    JLabel titleTwo = new JLabel("Player 2", SwingConstants.CENTER);
    JLabel totalScoreHolderP1 = new JLabel("",SwingConstants.CENTER);
    JLabel totalScoreHolderP2 = new JLabel("",SwingConstants.CENTER);

    JLabel winnerOfGame = new JLabel();

    public FinalScoreBoardPanel(List<Integer> scores){
        mainPanel.setLayout(new BorderLayout());

        titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));
        totalTitle.setFont(new Font("Montserrat", Font.BOLD, 18));

        layoutPanel.setLayout(new GridLayout(5,2,5,5));
        layoutPanel.setPreferredSize(new Dimension(200,200));
        layoutPanel.setBorder(new LineBorder(Color.BLACK));
        layoutPanel.setBackground(Color.white);

        titleOne.setText("Player 1");
        titleTwo.setText("Player 2");
        titleOne.setFont(new Font("Montserrat", Font.BOLD, 12));
        titleTwo.setFont(new Font("Montserrat", Font.BOLD, 12));

        layoutPanel.add(titleOne);
        layoutPanel.add(titleTwo);

        for (Integer i:scores) {
            layoutPanel.add(new JLabel(i.toString(),SwingConstants.CENTER));
        }

        playerOneScore = scores.get(0) + scores.get(2);
        totalScorePlayerOne = Integer.toString(playerOneScore);

        playerTwoScore = scores.get(1) + scores.get(3);
        totalScorePlayerTwo = Integer.toString(playerTwoScore);

        totalScoreHolderP1.setText(totalScorePlayerOne);
        totalScoreHolderP2.setText(totalScorePlayerTwo);

        layoutPanel.add(totalTitle);
        layoutPanel.add(emptyFiller);
        layoutPanel.add(totalScoreHolderP1);
        layoutPanel.add(totalScoreHolderP2);

        if (playerOneScore > playerTwoScore){
            winnerOfGame.setText("Player 1 is the winner!");
        } else if (playerTwoScore > playerOneScore){
            winnerOfGame.setText("Player 2 is the winner!");
        } else {
            winnerOfGame.setText("IT'S A TIE!");
        }

        mainPanel.add(titleOfWindow, BorderLayout.NORTH);
        mainPanel.add(layoutPanel, BorderLayout.CENTER);
        mainPanel.add(winnerOfGame, BorderLayout.SOUTH);
        add(mainPanel);
    }
}

