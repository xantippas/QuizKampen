import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class RoundsScorePanel extends JPanel {

        JPanel panell = new JPanel();
        JPanel mainPanel = new JPanel();
        JLabel titleOfWindow = new JLabel("Scores from Round:");
        JLabel titleOne = new JLabel();
        JLabel titleTwo = new JLabel();

        public RoundsScorePanel(List<Integer> scores){
            panell.setLayout(new BorderLayout());

            titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));

            mainPanel.setLayout(new GridLayout(3,3,5,5));
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

            panell.add(titleOfWindow, BorderLayout.NORTH);
            panell.add(mainPanel, BorderLayout.CENTER);
            add(panell);
        }
}

