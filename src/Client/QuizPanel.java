package Client;

import Server.Player;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.TimerTask;

public class QuizPanel extends JPanel{

    JFrame frame = new JFrame();
    String[][] quiz = new String[10][6];
    int questionCounter;
    int score;
    int roundsPlayed;

    JPanel mainPanel = new JPanel();
    JPanel bottomPanelForChoices = new JPanel();
    JLabel questionCard = new JLabel("", SwingConstants.CENTER);
    JLabel scoreCard = new JLabel("");
    String category;

    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();

    public QuizPanel(String s){
        this.category = s;
        //quizWindow();
        if (category.equals("history")){
            historyQuiz();
        } else if (category.equals("music")){
            musicQuiz();
        } else if (category.equals("science")){
            scienceQuiz();
        } else if (category.equals("gaming")){
            gamingQuiz();
        }


        /*frame.setVisible(true);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);*/
    }

    public JPanel quizWindow(){
        mainPanel.setBackground(new Color(135,200,255));
        mainPanel.setLayout(new GridLayout(2,1, 5, 5));

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

        //frame.add(mainPanel);

        return mainPanel;
    }

    public void update(){
        frame.setTitle(String.valueOf(score));

        questionCard.setText(quiz[questionCounter][0]);
        choice1.setText(quiz[questionCounter][1]);
        choice2.setText(quiz[questionCounter][2]);
        choice3.setText(quiz[questionCounter][3]);
        choice4.setText(quiz[questionCounter][4]);

        if (questionCounter == 2){
            showScoreCard();
        }
    }

    public void musicQuiz(){
        quiz[0][0] = "Vilket år dog Elvis Presley?";
        quiz[0][1] = "2006"; quiz[0][2] = "1977"; quiz[0][3] = "1976"; quiz[0][4] = "1981";
        quiz[0][5] = "2";

        quiz[1][0] = "Vilket fängelse sjöng Johnny Cash om i sin låt från 1955?";
        quiz[1][1] = "Folsom Prison"; quiz[1][2] = "The ADX"; quiz[1][3] = "Bangkok Hilton"; quiz[1][4] = "Walnut Grove";
        quiz[1][5] = "1";
        update();
    }

    public void historyQuiz(){
        quiz[0][0] = "WW2 ended?";
        quiz[0][1] = "1945"; quiz[0][2] = "1944"; quiz[0][3] = "what?"; quiz[0][4] = "1939";
        quiz[0][5] = "1";

        quiz[1][0] = "Vilken stad var den första kapitalen i USA?";
        quiz[1][1] = "Washington DC"; quiz[1][2] = "New York"; quiz[1][3] = "Boston"; quiz[1][4] = "San Francisco";
        quiz[1][5] = "2";
        update();
    }

    public void scienceQuiz(){
        quiz[0][0] = "What is the first element in the Periodic table?";
        quiz[0][1] = "Hydrogen"; quiz[0][2] = "Helium"; quiz[0][3] = "Oxygen"; quiz[0][4] = "Berryllium";
        quiz[0][5] = "1";

        quiz[1][0] = "Vilken planet är närmst solen?";
        quiz[1][1] = "Pluto"; quiz[1][2] = "Mars"; quiz[1][3] = "Mercurius"; quiz[1][4] = "Venus";
        quiz[1][5] = "3";
        update();
    }

    public void gamingQuiz(){
        quiz[0][0] = "Vad hette världens första spel?";
        quiz[0][1] = "Tetris"; quiz[0][2] = "Pong"; quiz[0][3] = "Minecraft"; quiz[0][4] = "Super Mario";
        quiz[0][5] = "2";

        quiz[1][0] = "Vilken är världens mest bästsäljande spelkonsol?";
        quiz[1][1] = "Playstation 4"; quiz[1][2] = "Super Nintendo"; quiz[1][3] = "Playstation 2"; quiz[1][4] = "Nintendo-64";
        quiz[1][5] = "3";
        update();
    }

    public void showScoreCard(){
        CategoryPanel chooseCategory = new CategoryPanel();
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.setLayout(new GridLayout(1,1));
        scoreCard.setText(String.valueOf(score));
        chooseCategory.setScoreOfPlayer(scoreCard);
        mainPanel.add(chooseCategory.categoryPicker());
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

    /*public static void main(String[] args) {
        QuizPanel quiz = new QuizPanel();
    }*/
}
