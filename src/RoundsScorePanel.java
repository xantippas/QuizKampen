import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class RoundsScorePanel extends JPanel {

        JPanel mainPanel = new JPanel();
        JPanel layoutPanel = new JPanel();

        JLabel titleOfWindow = new JLabel("Poäng:", SwingConstants.CENTER);
        JLabel titleOne = new JLabel("Player 1", SwingConstants.CENTER);
        JLabel titleTwo = new JLabel("Player 2", SwingConstants.CENTER);
        JLabel playerOneScore = new JLabel();
        JLabel playerTwoScore = new JLabel();

        String scorePlayerOne;
        String scorePlayerTwo;

        public RoundsScorePanel(List<Integer> scores){
            mainPanel.setLayout(new BorderLayout());

            titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));

            layoutPanel.setLayout(new GridLayout(2,2));
            layoutPanel.setPreferredSize(new Dimension(250,180));
            layoutPanel.setBorder(new LineBorder(Color.BLACK));
            layoutPanel.setBackground(Color.white);

            scorePlayerOne = scores.get(0).toString();
            scorePlayerTwo = scores.get(1).toString();
            playerOneScore.setText(scorePlayerOne);
            playerTwoScore.setText(scorePlayerTwo);
            
            playerOneScore.setVerticalAlignment(SwingConstants.CENTER);
            playerTwoScore.setVerticalAlignment(SwingConstants.CENTER);
            playerOneScore.setHorizontalAlignment(SwingConstants.CENTER);
            playerTwoScore.setHorizontalAlignment(SwingConstants.CENTER);

            layoutPanel.add(titleOne);
            layoutPanel.add(titleTwo);
            layoutPanel.add(playerOneScore);
            layoutPanel.add(playerTwoScore);

            mainPanel.add(titleOfWindow, BorderLayout.NORTH);
            mainPanel.add(layoutPanel, BorderLayout.CENTER);
            add(mainPanel);
        }
}

