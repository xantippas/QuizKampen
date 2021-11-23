import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CategoryPanel extends JPanel implements ActionListener {

    Client client;

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

        historyButton.addActionListener(this);
        scienceButton.addActionListener(this);
        gamingButton.addActionListener(this);
        musicButton.addActionListener(this);

        historyButton.setText(cat1);
        scienceButton.setText(cat2);
        gamingButton.setText(cat3);
        musicButton.setText(cat4);

        add(title);
        add(historyButton);
        add(scienceButton);
        add(gamingButton);
        add(musicButton);

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
        }
    }


    public String getCategoryToSendToServer() {
        return categoryToSendToServer;
    }

    public void setCategoryToSendToServer(String categoryToSendToServer) {
        this.categoryToSendToServer = categoryToSendToServer;
    }
}

