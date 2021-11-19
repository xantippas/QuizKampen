package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    JPanel mainPanel = new JPanel();
    JLabel title = new JLabel("Välkommen till QUIZ KAMPEN!", SwingConstants.CENTER);
    JPanel optionPanel = new JPanel();
    JButton play = new JButton("Spela");

    public JPanel createMenu() {
        mainPanel.setLayout(new GridLayout(2,1));

        title.setPreferredSize(new Dimension(250,200));
        title.setBounds(4,50,400,200);
        title.setFont(new Font("Montserrat", Font.BOLD, 18));
        //title.setForeground(Color.white); //color of text
        play.setBounds(80,280,250,50);
        play.setFont(new Font("Montserrat", Font.BOLD, 18));
        play.setForeground(Color.white);
        play.setBackground(Color.BLUE);

        play.addActionListener(this);
        optionPanel.add(play);

        //mainPanel.setBackground(Color.CYAN);
        mainPanel.add(title);
        mainPanel.add(optionPanel);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            GameStatusPage gameStatus = new GameStatusPage();
            mainPanel.removeAll();
            mainPanel.add(gameStatus.currentGameStatus());
            mainPanel.revalidate();
            mainPanel.repaint();

        }
    }
}
