import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WaitingForPlayerPanel extends JPanel {

    JPanel mainPanel = new JPanel();
    JLabel currentStatus = new JLabel("",SwingConstants.CENTER);
    String s;

    public WaitingForPlayerPanel(String s) {
        setLayout(new BorderLayout());

        this.s = s;

        currentStatus.setFont(new Font("Montserrat", Font.ITALIC, 18));
        currentStatus.setText(s);

        mainPanel.add(currentStatus);
        add(mainPanel, BorderLayout.CENTER);
    }
}

