import javax.swing.*;

public class WaitingForPlayerPanel extends JPanel {

        JLabel currentStatus = new JLabel();
        String s;

        public WaitingForPlayerPanel(String s){
            this.s=s;
            currentStatus.setText(s);
            add(currentStatus);
        }
}

