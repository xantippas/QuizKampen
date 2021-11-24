import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class FinalScoreBoardPanel extends JPanel {

    JPanel mainPanel = new JPanel();
    JPanel panell = new JPanel();
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
        panell.setLayout(new BorderLayout());

        titleOfWindow.setFont(new Font("Montserrat", Font.BOLD, 18));

        mainPanel.setLayout(new GridLayout(5,3,5,5));
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

        /*scoreOne.setText(scores.get(0).toString());
        scoreTwo.setText(scores.get(1).toString());
        mainPanel.add(scoreOne);
        mainPanel.add(scoreTwo);*/

        panell.add(titleOfWindow, BorderLayout.NORTH);
        panell.add(mainPanel, BorderLayout.CENTER);
        add(panell);
        /*System.out.println(scores);
        setLayout(new BorderLayout());
        add(titleOfWindow, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(2,2));
        //mainPanel2.setLayout(new GridLayout(2,2));

        //mainPanel.add(titleOne);
        //mainPanel.add(titleTwo);
        scoreOne.setText(scores.get(0).toString());
        scoreTwo.setText(scores.get(1).toString());
        scoreOne.setFont(new Font("Arial", Font.BOLD, 18));
        scoreTwo.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(scoreOne);
        mainPanel.add(scoreOne);
        mainPanel2.add(titleOne);
        mainPanel2.add(titleTwo);
        scoreOneFinal.setText(scores.get(2).toString());
        scoreTwoFinal.setText(scores.get(3).toString());
        mainPanel.add(scoreOneFinal);
        mainPanel.add(scoreTwoFinal);

        add(mainPanel, BorderLayout.CENTER);
        //add(mainPanel2, BorderLayout.CENTER);*/
    }
}

