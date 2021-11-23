import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.List;

public class QuizPanel extends JPanel implements ActionListener{

    PrintWriter out;

    JLabel categoryShowing = new JLabel();
    JPanel questionCard = new JPanel();
    JPanel choiceBar = new JPanel();
    JLabel question = new JLabel();
    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();
    String correctAnswer;

    public QuizPanel(String title, String q, List<String> a, String correctAnswer, PrintWriter out){
        this.out = out;
        this.correctAnswer = correctAnswer;
        questionCard.setLayout(new GridLayout(2,1));
        categoryShowing.setText(title);
        question.setText(q);
        questionCard.add(question);
        choiceBar.setLayout(new GridLayout(2,2));

        choice1.setText(a.get(0));
        choice2.setText(a.get(1));
        choice3.setText(a.get(2));
        choice4.setText(a.get(3));

        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice4.addActionListener(this);

        choiceBar.add(choice1);
        choiceBar.add(choice2);
        choiceBar.add(choice3);
        choiceBar.add(choice4);

        questionCard.add(choiceBar);
        add(questionCard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choice1){
            if (choice1.getText().equalsIgnoreCase(correctAnswer)){
                choice1.setBackground(Color.GREEN);
                out.println("1");
            } else {
                choice1.setBackground(Color.RED);
                out.println("0");
            }

        } else if (e.getSource() == choice2){
            if (choice2.getText().equalsIgnoreCase(correctAnswer)){
                choice2.setBackground(Color.GREEN);
                out.println("1");
            } else {
                choice2.setBackground(Color.RED);
                out.println("0");
            }
        } else if (e.getSource() == choice3){
            if (choice3.getText().equalsIgnoreCase(correctAnswer)){
                choice3.setBackground(Color.GREEN);
                out.println("1");
            } else {
                choice3.setBackground(Color.RED);
                out.println("0");
            }
        } else if (e.getSource() == choice4){
            if (choice4.getText().equalsIgnoreCase(correctAnswer)){
                choice4.setBackground(Color.GREEN);
                out.println("1");
            } else {
                choice4.setBackground(Color.RED);
                out.println("0");
            }
        }
    }

}