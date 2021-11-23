import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FinalScoreBoardPanel extends JPanel {

    JPanel mainPanel = new JPanel();
    JPanel mainPanel2 = new JPanel();
    JLabel titleOfWindow = new JLabel("Game finished, Final scores!");
    JLabel titleOfRoundOne = new JLabel("Round 1 scores");
    JLabel titleOfRoundTwo = new JLabel("Round 2 scores");
    JLabel titleOne = new JLabel("PLayer 1");
    JLabel titleTwo = new JLabel("Player 2");
    JLabel scoreOne = new JLabel();
    JLabel scoreTwo = new JLabel();
    JLabel scoreOneFinal = new JLabel();
    JLabel scoreTwoFinal = new JLabel();

    public FinalScoreBoardPanel(List<Integer> scores){
        setLayout(new BorderLayout());
        add(titleOfWindow, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel2.setLayout(new GridLayout(2,2));

        mainPanel.add(titleOne);
        mainPanel.add(titleTwo);
        scoreOne.setText(scores.get(0).toString());
        scoreTwo.setText(scores.get(1).toString());
        mainPanel.add(scoreOne);
        mainPanel.add(scoreOne);
        mainPanel2.add(titleOne);
        mainPanel2.add(titleTwo);
        /*scoreOneFinal.setText(scores.get(2).toString());
        scoreTwoFinal.setText(scores.get(3).toString());*/
        mainPanel2.add(scoreOneFinal);
        mainPanel2.add(scoreTwoFinal);

        add(mainPanel, BorderLayout.CENTER);
        add(mainPanel2, BorderLayout.CENTER);
    }
}
