import javax.swing.*;
import java.awt.*;

public class ClientGameStartingPanel extends JPanel {

    String s;

    JPanel mainPanel = new JPanel();
    JLabel welcomeMessage = new JLabel("");

    public ClientGameStartingPanel(String s) {
        setLayout(new BorderLayout());

        this.s = s;

        welcomeMessage.setFont(new Font("Montserrat", Font.BOLD, 18));
        welcomeMessage.setText(s);

        mainPanel.add(welcomeMessage);
        add(mainPanel, BorderLayout.CENTER);
    }
}

