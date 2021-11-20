package Client;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class QuizPanel extends JFrame{

    JFrame frame = new JFrame();
    String[][] quiz = new String[10][6];
    int questionCounter =0;
    int score =0;

    JPanel mainPanel = new JPanel();
    JPanel bottomPanelForChoices = new JPanel();
    JLabel questionCard = new JLabel("", SwingConstants.CENTER);
    JLabel scoreCard = new JLabel("");

    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();

    public QuizPanel(){
        quizWindow();
        initData();
        update();

        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

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

        choice1.setBackground(Color.white);
        choice2.setBackground(Color.white);
        choice3.setBackground(Color.white);
        choice4.setBackground(Color.white);

        choice1.addActionListener(button1);
        choice2.addActionListener(button2);
        choice3.addActionListener(button3);
        choice4.addActionListener(button4);

        bottomPanelForChoices.add(choice1);
        bottomPanelForChoices.add(choice2);
        bottomPanelForChoices.add(choice3);
        bottomPanelForChoices.add(choice4);

        mainPanel.add(questionCard);
        mainPanel.add(bottomPanelForChoices);

        frame.add(mainPanel);

        return mainPanel;
    }

    public void update(){
        frame.setTitle(String.valueOf(score));

        questionCard.setText(quiz[questionCounter][0]);
        choice1.setText(quiz[questionCounter][1]);
        choice2.setText(quiz[questionCounter][2]);
        choice3.setText(quiz[questionCounter][3]);
        choice4.setText(quiz[questionCounter][4]);
    }

    public void initData(){
        quiz[0][0] = "What is the capital of Sweden?";
        quiz[0][1] = "Copenhagen"; quiz[0][2] = "Malmo"; quiz[0][3] = "Stockholm"; quiz[0][4] = "Gothenburg";
        quiz[0][5] = "3";

        quiz[1][0] = "What is the color of the sky on a clear day?";
        quiz[1][1] = "Purple"; quiz[1][2] = "Blue"; quiz[1][3] = "White"; quiz[1][4] = "Gray";
        quiz[1][5] = "2";
    }

    ActionListener button1 = e -> {
        if (quiz[questionCounter][5]=="1") {
            choice1.setBackground(Color.GREEN);
            score++;
        } else {
            choice1.setBackground(Color.RED);
        }
        questionCounter++;
        update();
    };
    ActionListener button2 = e -> {
        if(quiz[questionCounter][5]=="2"){
            choice2.setBackground(Color.GREEN);
            score++;
        } else {
            choice2.setBackground(Color.RED);
        }
        questionCounter++;
        update();
    };
    ActionListener button3 = e -> {
        if(quiz[questionCounter][5]=="3"){
            choice3.setBackground(Color.GREEN);
            score++;
        } else {
            choice3.setBackground(Color.RED);
        }
        questionCounter++;
        update();
    };
    ActionListener button4 = e -> {
        if(quiz[questionCounter][5]=="4"){
            choice4.setBackground(Color.GREEN);
            score++;
        } else {
            choice4.setBackground(Color.RED);
        }
        questionCounter++;
        update();
    };

    public static void main(String[] args) {
        QuizPanel quiz = new QuizPanel();
    }
}
