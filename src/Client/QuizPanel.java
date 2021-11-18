package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPanel extends JPanel implements ActionListener {

    JPanel mainPanel = new JPanel();
    JPanel quizCard = new JPanel();
    JPanel quizChoices = new JPanel();
    JLabel header = new JLabel("Question");
    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();

    public JPanel quizWindow(){

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(quizCard, BorderLayout.NORTH);
        quizCard.add(header);
        mainPanel.add(quizChoices, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        quizChoices.setLayout(new GridLayout(2,2,5,5));
        quizChoices.add(choice1);
        quizChoices.add(choice2);
        quizChoices.add(choice3);
        quizChoices.add(choice4);
        mainPanel.setBackground(Color.CYAN);
        quizChoices.setBackground(Color.CYAN);
        quizCard.setBackground(Color.CYAN);
        choice1.setBackground(Color.LIGHT_GRAY);
        choice2.setBackground(Color.LIGHT_GRAY);
        choice3.setBackground(Color.LIGHT_GRAY);
        choice4.setBackground(Color.LIGHT_GRAY);


        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == )
    }
}
