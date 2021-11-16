package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    JPanel mainPanel = new JPanel();
    JPanel title = new JPanel();
    JPanel optionPanel = new JPanel();
    JButton play = new JButton("Spela");

    public JPanel createMenu() {

        title.add(new JLabel("Välkommen till QUIZ KAMPEN!"));

        play.addActionListener(this);
        optionPanel.add(play);
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(optionPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            GameStatusPage gameStatus = new GameStatusPage();
            mainPanel.removeAll();
            mainPanel.add(gameStatus.currentGameStatus().mainPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
}
