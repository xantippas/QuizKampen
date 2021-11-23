import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CategoryPanel extends JPanel implements ActionListener {

    JPanel mainPanel = new JPanel();
    String cat1;
    String cat2;
    String cat3;
    String cat4;
    JLabel title = new JLabel("Choose a category:");
    JButton historyButton = new JButton();
    JButton scienceButton = new JButton();
    JButton gamingButton = new JButton();
    JButton musicButton = new JButton();
    public String categoryToSendToServer;

    PrintWriter out;

    public CategoryPanel(String cat1, String cat2, String cat3, String cat4, PrintWriter out) {
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.cat4 = cat4;

        this.out = out;

        setLayout(new BorderLayout());
        mainPanel.setLayout(new GridLayout(4,1,5,5));
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        title.setFont(new Font("Montserrat", Font.BOLD, 18));

        historyButton.addActionListener(this);
        scienceButton.addActionListener(this);
        gamingButton.addActionListener(this);
        musicButton.addActionListener(this);

        historyButton.setText(cat1);
        scienceButton.setText(cat2);
        gamingButton.setText(cat3);
        musicButton.setText(cat4);

        historyButton.setSize(new Dimension(50,50));
        scienceButton.setSize(new Dimension(50,50));
        gamingButton.setSize(new Dimension(50,50));
        musicButton.setSize(new Dimension(50,50));

        mainPanel.add(historyButton);
        mainPanel.add(scienceButton);
        mainPanel.add(gamingButton);
        mainPanel.add(musicButton);

        add(title, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyButton) {
            setCategoryToSendToServer("history");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == scienceButton) {
            setCategoryToSendToServer("science");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == gamingButton) {
            setCategoryToSendToServer("gaming");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == musicButton) {
            setCategoryToSendToServer("music");
            out.println(getCategoryToSendToServer());
        }
    }


    public String getCategoryToSendToServer() {
        return categoryToSendToServer;
    }

    public void setCategoryToSendToServer(String categoryToSendToServer) {
        this.categoryToSendToServer = categoryToSendToServer;
    }
}

