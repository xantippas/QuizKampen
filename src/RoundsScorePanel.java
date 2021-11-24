import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class RoundsScorePanel extends JPanel {

        JPanel mainPanel = new JPanel();
        JPanel layoutPanel = new JPanel();

        JLabel titleOfWindow = new JLabel("Poäng:");
        JLabel titleOne = new JLabel("Player 1");
        JLabel titleTwo = new JLabel("Player 2");
        JLabel playerOneScore = new JLabel();
        JLabel playerTwoScore = new JLabel();

        String scorePlayerOne;
        String scorePlayerTwo;

        public RoundsScorePanel(List<Integer> scores){
            mainPanel.setLayout(new BorderLayout());
            System.out.println(scores);

            titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));

            layoutPanel.setLayout(new GridLayout(2,2,5,5));
            layoutPanel.setPreferredSize(new Dimension(200,200));
            layoutPanel.setBorder(new LineBorder(Color.BLACK));
            layoutPanel.setBackground(Color.white);
            
            //titleOne.setFont(new Font("Montserrat", Font.PLAIN, 12));
            //titleTwo.setFont(new Font("Montserrat", Font.PLAIN, 12));

            scorePlayerOne = scores.get(0).toString();
            scorePlayerTwo = scores.get(1).toString();
            playerOneScore.setText(scorePlayerOne);
            playerTwoScore.setText(scorePlayerTwo);

            layoutPanel.add(titleOne);
            layoutPanel.add(playerOneScore);
            layoutPanel.add(titleTwo);
            layoutPanel.add(playerTwoScore);

            System.out.println(scorePlayerOne);
            System.out.println(scorePlayerTwo);

            mainPanel.add(titleOfWindow, BorderLayout.NORTH);
            mainPanel.add(layoutPanel, BorderLayout.CENTER);
            add(mainPanel);
        }
}

