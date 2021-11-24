import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

public class Client extends JFrame {

    Properties properties = new Properties();

    JPanel mainPanel = new JPanel();
    JLabel statusWaiting = new JLabel("Väntar på motståndare");

    int roundCounter = 0;

    public Client() {
        int portNumber = 12345;
        String hostName = "192.168.0.100";

        statusWaiting.setFont(new Font("Montserrat", Font.BOLD, 18));
        mainPanel.add(statusWaiting);
        add(mainPanel);
        setVisible(true);
        setSize(550, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String key = readPropertiesFromPropertyFile("roundNum");
        int amountOfRounds = Integer.parseInt(key);

        key = readPropertiesFromPropertyFile("quizNumInRound");
        int amountOfQuestions = Integer.parseInt(key);

        try {
            Socket socket = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            InputStream getObjectFromServer = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(getObjectFromServer);

            OutputStream osStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(osStream);


            String setTitleForPlayerWindow = (String) objectInputStream.readObject();

            mainPanel.removeAll();
            setTitle(setTitleForPlayerWindow);
            mainPanel.revalidate();
            mainPanel.repaint();
            repaint();

            String gameIsStartingText = (String) objectInputStream.readObject();
            ClientGameStartingPanel gameStarting = new ClientGameStartingPanel(gameIsStartingText);

            mainPanel.removeAll();
            mainPanel.add(gameStarting);
            mainPanel.revalidate();
            mainPanel.repaint();
            repaint();

            try {
                Thread.sleep(2000);
            } catch(Exception e){
                e.printStackTrace();
            }

            while (roundCounter < amountOfRounds) {
                List<String> cats = (List<String>) objectInputStream.readObject();
                ClientCategoryPanel categoriesForPlayer = new ClientCategoryPanel(cats.get(0), cats.get(1), cats.get(2), cats.get(3), out);

                mainPanel.removeAll();
                mainPanel.add(categoriesForPlayer);
                mainPanel.revalidate();
                mainPanel.repaint();
                repaint();


                for (int i = 0; i < amountOfQuestions; i++) {
                    List<Questions> allQs = (List<Questions>) objectInputStream.readObject();
                    ClientQuizPanel playQuiz = new ClientQuizPanel(allQs.get(i).getCategoryChosen(), allQs.get(i).getQuestion(), allQs.get(i).getAnswers(), allQs.get(i).getCorrectAnswerInList(), out);

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


                if (roundCounter == 1) {
                    List<Integer> finalScores = (List<Integer>) objectInputStream.readObject();
                    ClientFinalScoreBoardPanel endOfGame = new ClientFinalScoreBoardPanel(finalScores);
                    mainPanel.removeAll();
                    mainPanel.add(endOfGame);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    repaint();
                } else {
                    List<Integer> roundOneScores = (List<Integer>) objectInputStream.readObject();
                    ClientRoundsScorePanel scoreBoard = new ClientRoundsScorePanel(roundOneScores);
                    mainPanel.removeAll();
                    mainPanel.add(scoreBoard);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    repaint();

                    try {
                        Thread.sleep(4000);
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

