import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

public class Client extends JFrame {

    List<Integer> myScores;
    Properties properties = new Properties();

    BufferedReader in;
    PrintWriter out;
    String toServer = "";
    BufferedReader inputConsole;

    int roundCounter = 0;

    JPanel mainPanel = new JPanel();
    JLabel statusWaiting = new JLabel("Waiting for Opponent");

    public Client() {

        int portNumber = 4444;
        String hostName = "172.20.200.182";

        statusWaiting.setFont(new Font("Montserrat", Font.BOLD, 18));
        mainPanel.add(statusWaiting);
        //setTitle("Player " + a); //send over objects from game run to set title with
        add(mainPanel);
        setVisible(true);
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String key = readPropertiesFromPropertyFile("roundNum");
        int amountOfRounds = Integer.parseInt(key);

        key = readPropertiesFromPropertyFile("quizNumInRound");
        int amountOfQuestions = Integer.parseInt(key);


        try {
            Socket socket = new Socket(hostName, portNumber);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            InputStream getObjectFromServer = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(getObjectFromServer);

            OutputStream osStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(osStream);

            inputConsole = new BufferedReader(new InputStreamReader(System.in));
            while (roundCounter < amountOfRounds) {
                //title of window for player
                String ss = (String) objectInputStream.readObject();

                mainPanel.removeAll();
                setTitle(ss);
                mainPanel.revalidate();
                mainPanel.repaint();
                repaint();

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
                for (int i = 0; i < amountOfQuestions; i++) {
                    List<Questions> allQs = (List<Questions>) objectInputStream.readObject();
                    QuizPanel playQuiz = new QuizPanel(allQs.get(i).getCategoryChosen(), allQs.get(i).getQuestion(), allQs.get(i).getAnswers(), allQs.get(i).getCorrectAnswerInList(), out);

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
                System.out.println(roundCounter);
                if (roundCounter == 1) {
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

                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                roundCounter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        Client c = new Client();
    }

    public String readPropertiesFromPropertyFile(String s) {
        try (FileInputStream fileInputStream = new FileInputStream("src/gameConfig.properties")) {

            properties.load(fileInputStream);
            String value = properties.getProperty(s);
            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

