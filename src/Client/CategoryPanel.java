package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryPanel extends JPanel implements ActionListener{

    String categoryChosen;
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel categoryPanel = new JPanel();
    JLabel header = new JLabel("Pick a category");
    JButton categoryHistory = new JButton("History");
    JButton categoryScience = new JButton("Science");
    JButton categoryGaming = new JButton("Gaming");
    JButton categoryMusic = new JButton("Music");

    public JPanel categoryPicker(){
        mainPanel.setLayout(new BorderLayout());
        headerPanel.add(header);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        categoryPanel.add(categoryHistory);
        categoryPanel.add(categoryScience);
        categoryPanel.add(categoryGaming);
        categoryPanel.add(categoryMusic);
        mainPanel.add(categoryPanel, BorderLayout.CENTER);

        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categoryHistory){
            categoryChosen = "History";
        }
        else if (e.getSource() == categoryGaming){
            categoryChosen = "Gaming";
        }
        else if (e.getSource() == categoryMusic){
            categoryChosen = "Music";
        }
        else if (e.getSource() == categoryScience) {
            categoryChosen = "Science";
        }
    }
}
