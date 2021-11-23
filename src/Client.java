import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client extends JFrame {

    List<Integer> myScores;

    BufferedReader in;
    PrintWriter out;
    String toServer = "";
    String fromServer;
    BufferedReader inputConsole;

    public int questionCounter = 0;
    int playerScore = 0;

    JPanel mainPanel = new JPanel();
    JLabel statusWaiting = new JLabel("Waiting for Opponent");

    public Client() {
        int portNumber = 4444;
        String hostName = "192.168.0.101";

        statusWaiting.setFont(new Font("Montserrat", Font.BOLD, 18));
        mainPanel.add(statusWaiting);
        add(mainPanel);
        setVisible(true);
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        while (playerScore < 2) {
            try {
                Socket socket = new Socket(hostName, portNumber);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                InputStream getObjectFromServer = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(getObjectFromServer);

                OutputStream osStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(osStream);

                inputConsole = new BufferedReader(new InputStreamReader(System.in));

                //waiting window
                String s = (String) objectInputStream.readObject();
                WaitingForPlayerPanel playing = new WaitingForPlayerPanel(s);

                mainPanel.removeAll();
                mainPanel.add(playing);
                mainPanel.revalidate();
                mainPanel.repaint();
                repaint();


                //category window
                List<String> cats = (List<String>) objectInputStream.readObject();
                CategoryPanel categories = new CategoryPanel(cats.get(0), cats.get(1), cats.get(2), cats.get(3), out);

                mainPanel.removeAll();
                mainPanel.add(categories);
                mainPanel.revalidate();
                mainPanel.repaint();
                repaint();

                //quiz window starting
                for (int i = 0; i < 4; i++) {
                    List<Questions> allQs = (List<Questions>) objectInputStream.readObject();
                    QuizPanel playQuiz = new QuizPanel(toServer, allQs.get(i).getQuestion(), allQs.get(i).getAnswers(), allQs.get(i).getCorrectAnswerInList(), out);

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mainPanel.removeAll();
                    mainPanel.add(playQuiz);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    repaint();
                }

                //score board
                System.out.println(playerScore);
                if (playerScore == 1){
                    List<Integer> finalScore = (List<Integer>) objectInputStream.readObject();
                    FinalScoreBoardPanel endGame = new FinalScoreBoardPanel(finalScore);
                    mainPanel.removeAll();
                    mainPanel.add(endGame);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    repaint();
                } else {
                    this.myScores = (List<Integer>) objectInputStream.readObject();
                    RoundsScorePanel scoreBoard = new RoundsScorePanel(this.myScores);
                    mainPanel.removeAll();
                    mainPanel.add(scoreBoard);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    repaint();

                    try{
                        Thread.sleep(2000);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                playerScore++;

            /*List<String> cats2 = (List<String>) objectInputStream.readObject();
            categoryPanel categories2 = new categoryPanel(cats2.get(0), cats2.get(1), cats2.get(2), out);

            mainPanel.removeAll();
            mainPanel.add(categories2);
            mainPanel.revalidate();
            mainPanel.repaint();
            repaint();

            //quiz window starting
            for (int i = 0; i < 4; i++) {
                List<Questions> allQss = (List<Questions>) objectInputStream.readObject();
                quizPanel playQuizz = new quizPanel(toServer, allQss.get(i).getQuestion(), allQss.get(i).getAnswers(), allQss.get(i).getCorrectAnswerInList(), out);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainPanel.removeAll();
                mainPanel.add(playQuizz);
                mainPanel.revalidate();
                mainPanel.repaint();
                repaint();
            }

            //score board
            List<Integer> myScoress = (List<Integer>) objectInputStream.readObject();
            roundOneScorePanel scoreBoardd = new roundOneScorePanel(myScoress);
            mainPanel.removeAll();
            mainPanel.add(scoreBoardd);
            mainPanel.revalidate();
            mainPanel.repaint();
            repaint();*/

                //initialize another round of quiz game
                //add category panel
                //add quiz panel
                //add final score page that shows points for round one and round two separately

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client c = new Client();

    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public void setQuestionCounter(int questionCounter) {
        this.questionCounter = questionCounter;
    }
}
