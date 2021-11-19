package Client;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPanel extends JPanel implements ActionListener {

    JPanel mainPanel = new JPanel();
    JPanel bottomPanelForChoices = new JPanel();
    JLabel questionCard = new JLabel("Question", SwingConstants.CENTER);

    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();

    public JPanel quizWindow(){
        mainPanel.setBackground(new Color(135,200,255));
        mainPanel.setLayout(new GridLayout(2,1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        questionCard.setOpaque(true);
        questionCard.setBackground(Color.white);
        questionCard.setBorder(new EtchedBorder(1));

        bottomPanelForChoices.setLayout(new GridLayout(2,2,5,5));
        bottomPanelForChoices.setOpaque(true);
        bottomPanelForChoices.setBackground(new Color(135,200,255));

        bottomPanelForChoices.add(choice1);
        bottomPanelForChoices.add(choice2);
        bottomPanelForChoices.add(choice3);
        bottomPanelForChoices.add(choice4);

        mainPanel.add(questionCard);
        mainPanel.add(bottomPanelForChoices);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == )
    }
}
