import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientCategoryPanel extends JPanel implements ActionListener {

    String cat1;
    String cat2;
    String cat3;
    String cat4;
    PrintWriter out;

    JPanel mainPanel = new JPanel();
    JLabel title = new JLabel("Välj en kategori:");
    JButton historyButton = new JButton();
    JButton scienceButton = new JButton();
    JButton gamingButton = new JButton();
    JButton musicButton = new JButton();
    public String categoryToSendToServer; //does this need to be public??

    public ClientCategoryPanel(String cat1, String cat2, String cat3, String cat4, PrintWriter out) {
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
            setCategoryToSendToServer("historia");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == scienceButton) {
            setCategoryToSendToServer("naturvetenskap");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == gamingButton) {
            setCategoryToSendToServer("spel");
            out.println(getCategoryToSendToServer());
        } else if (e.getSource() == musicButton) {
            setCategoryToSendToServer("musik");
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

