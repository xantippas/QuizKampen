import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class RoundsScorePanel extends JPanel {

        JPanel mainPanel = new JPanel();
        JLabel titleOfWindow = new JLabel("Round scores");
        JLabel titleOne = new JLabel();
        JLabel titleTwo = new JLabel();
        JLabel scoreOne = new JLabel();
        JLabel scoreTwo = new JLabel();
        JLabel scoreOneFinal = new JLabel();
        JLabel scoreTwoFinal = new JLabel();

        public RoundsScorePanel(List<Integer> scores){
            mainPanel.setLayout(new GridLayout(3,3,5,5));
            mainPanel.setBorder(new LineBorder(Color.BLACK));
            titleOne.setText("Player 1");
            titleTwo.setText("Player 2");
            mainPanel.add(titleOne);
            mainPanel.add(titleTwo);

            for (Integer i:scores) {
                mainPanel.add(new JLabel(i.toString()));
            }

        /*scoreOne.setText(scores.get(0).toString());
        scoreTwo.setText(scores.get(1).toString());
        mainPanel.add(scoreOne);
        mainPanel.add(scoreTwo);*/

            add(titleOfWindow);
            add(mainPanel);
        }
}

