package Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryPanel extends JPanel implements ActionListener{

    String categoryChosen;
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel categoryPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JLabel scoreOfPlayer = new JLabel("");
    JLabel header = new JLabel("Pick a category");
    JButton categoryHistory = new JButton("History");
    JButton categoryScience = new JButton("Science");
    JButton categoryGaming = new JButton("Gaming");
    JButton categoryMusic = new JButton("Music");

    public JPanel categoryPicker(){
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.setBorder(new EmptyBorder(10,20,20,20));
        mainPanel.setBackground(new Color(0,162,255));
        mainPanel.setLayout(new BorderLayout(5,5));
        header.setFont(new Font("Montserrat", Font.BOLD, 18));
        header.setForeground(Color.white);
        headerPanel.setBackground(Color.BLUE);
        headerPanel.add(header);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        scorePanel.add(scoreOfPlayer);
        mainPanel.add(scorePanel, BorderLayout.WEST);

        categoryHistory.setPreferredSize(new Dimension(180,40));
        categoryScience.setPreferredSize(new Dimension(180,40));
        categoryGaming.setPreferredSize(new Dimension(180,40));
        categoryMusic.setPreferredSize(new Dimension(180,40));

        categoryHistory.addActionListener(this);
        categoryScience.addActionListener(this);
        categoryGaming.addActionListener(this);
        categoryMusic.addActionListener(this);

        categoryPanel.add(categoryHistory);
        categoryPanel.add(categoryScience);
        categoryPanel.add(categoryGaming);
        categoryPanel.add(categoryMusic);
        categoryPanel.setBorder(new EmptyBorder(40,20,20,20));
        categoryPanel.setBackground(new Color(0,162,255));
        mainPanel.add(categoryPanel, BorderLayout.CENTER);

        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categoryHistory){
            categoryChosen = "history";
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            mainPanel.remove(categoryHistory);
            QuizPanel quiz = new QuizPanel(categoryChosen);
            mainPanel.add(quiz.quizWindow());

        }
        else if (e.getSource() == categoryGaming){
            categoryChosen = "gaming";
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            QuizPanel quiz = new QuizPanel(categoryChosen);
            mainPanel.add(quiz.quizWindow());
        }
        else if (e.getSource() == categoryMusic){
            categoryChosen = "music";
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            QuizPanel quiz = new QuizPanel(categoryChosen);
            mainPanel.add(quiz.quizWindow());
        }
        else if (e.getSource() == categoryScience) {
            categoryChosen = "science";
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            QuizPanel quiz = new QuizPanel(categoryChosen);
            mainPanel.add(quiz.quizWindow());
        }
    }

    public void setScoreOfPlayer(JLabel scoreOfPlayer) {
        this.scoreOfPlayer = scoreOfPlayer;
    }
}
