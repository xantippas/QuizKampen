package Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel{

    JPanel mainPanel = new JPanel();
    JLabel title = new JLabel("Välkommen till QUIZ KAMPEN!", SwingConstants.CENTER);
    String s;
    public JLabel message = new JLabel("Waiting for Opponent...", SwingConstants.CENTER);
    JPanel optionPanel = new JPanel();
    JButton play = new JButton("Spela");

    public JPanel createMenu() {
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.setBackground(new Color(0,162,255));
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        title.setPreferredSize(new Dimension(250,200));
        title.setFont(new Font("Montserrat", Font.BOLD, 18));
        title.setForeground(Color.white); //color of text

        message.setFont(new Font("Montserrat", Font.ITALIC, 16));
        //message.setForeground(Color.white);
        message.setOpaque(true);
        message.setBackground(Color.white);

        play.setFont(new Font("Montserrat", Font.BOLD, 18));
        play.setForeground(Color.white);
        play.setBackground(Color.BLUE);
        play.addActionListener(al);

        optionPanel.setLayout(null);
        play.setBounds(85,50, 200,50);
        optionPanel.setBackground(new Color(0,162,255));
        optionPanel.add(play);

        mainPanel.add(title);
        mainPanel.add(message);
        mainPanel.add(optionPanel);
        //add(mainPanel);

        /*setVisible(true);
        setSize(420,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);*/

        return mainPanel;
    }

    public JPanel startPlaying() {
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.setBackground(new Color(0,162,255));
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        title.setPreferredSize(new Dimension(250,200));
        title.setFont(new Font("Montserrat", Font.BOLD, 18));
        title.setForeground(Color.white); //color of text

        message.setText("Ready To play!");
        message.setFont(new Font("Montserrat", Font.ITALIC, 16));
        //message.setForeground(Color.white);
        message.setOpaque(true);
        message.setBackground(Color.white);

        play.setFont(new Font("Montserrat", Font.BOLD, 18));
        play.setForeground(Color.white);
        play.setBackground(Color.BLUE);
        play.addActionListener(al);

        optionPanel.setLayout(null);
        play.setBounds(85,50, 200,50);
        optionPanel.setBackground(new Color(0,162,255));
        optionPanel.add(play);

        mainPanel.add(title);
        mainPanel.add(message);
        mainPanel.add(optionPanel);

        return mainPanel;
    }



    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == play) {
                GameStatusPage gameStatus = new GameStatusPage();
                mainPanel.removeAll();
                mainPanel.setLayout(new GridLayout(1,1));
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.add(gameStatus.currentGameStatus());
            }
        }
    };

}
