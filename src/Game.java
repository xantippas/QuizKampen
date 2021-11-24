import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {

    DatabaseOfQuestions q = new DatabaseOfQuestions();

    List<Integer> firstRoundScores = new ArrayList<>();
    List<Integer> finalScores = new ArrayList<>();

    PrintWriter outPlayerOne;
    BufferedReader inPlayerOne;
    PrintWriter outPlayerTwo;
    BufferedReader inPlayerTwo;

    String response;
    String chosenCategory;
    String chosenCategoryRoundTwo;
    String gameStartingText = "Lets play a game | Player 1 börjar";
    String player1 = "Player 1";
    String player2 = "Player 2";

    int questionCounter = 0;

    OutputStream osPlayerOne;
    ObjectOutputStream objectOutputPlayerOne;

    OutputStream osPlayerTwo;
    ObjectOutputStream objectOutputPlayerTwo;

    InputStream getObjectFromServerPlayerOne;
    ObjectInputStream objectInputPlayerOne;

    InputStream getObjectFromServerPlayerTwo;
    ObjectInputStream objectInputPlayerTwo;

    Socket playerOne;
    Socket playerTwo;

    public Game(Socket playerOne, Socket playerTwo) throws IOException {
        this.playerTwo = playerTwo;
        this.playerOne = playerOne;

        outPlayerOne = new PrintWriter(playerOne.getOutputStream(), true);
        inPlayerOne = new BufferedReader(new InputStreamReader(playerOne.getInputStream()));
        outPlayerTwo = new PrintWriter(playerTwo.getOutputStream(), true);
        inPlayerTwo = new BufferedReader(new InputStreamReader(playerTwo.getInputStream()));

        osPlayerOne = playerOne.getOutputStream();
        objectOutputPlayerOne = new ObjectOutputStream(osPlayerOne);
        osPlayerTwo = playerTwo.getOutputStream();
        objectOutputPlayerTwo = new ObjectOutputStream(osPlayerTwo);

        getObjectFromServerPlayerOne = playerOne.getInputStream();
        objectInputPlayerOne = new ObjectInputStream(getObjectFromServerPlayerOne);
        getObjectFromServerPlayerTwo = playerTwo.getInputStream();
        objectInputPlayerTwo = new ObjectInputStream(getObjectFromServerPlayerTwo);
    }

    @Override
    public void run() {
        try {
            //sending player titles
            objectOutputPlayerOne.writeObject(player1);
            objectOutputPlayerTwo.writeObject(player2);

            //starting window
            objectOutputPlayerOne.writeObject(gameStartingText);
            objectOutputPlayerTwo.writeObject(gameStartingText);

            int playerOneScoreRoundOne = 0;
            int playerTwoScoreRoundOne = 0;
            int playerOneScoreRoundTwo = 0;
            int playerTwoScoreRoundTwo = 0;
            //category window
            objectOutputPlayerOne.writeObject(q.myCategories());
            objectOutputPlayerTwo.writeObject(q.myCategories());

            //player one chooses category
            //return category value to send correct quiz
            chosenCategory = inPlayerOne.readLine();
            //send quiz questions to player one and two
            if (chosenCategory.equalsIgnoreCase("historia")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.historyCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("naturvetenskap")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("spel")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("musik")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.musicCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.musicCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    questionCounter++;
                }

            }
            firstRoundScores.add(playerOneScoreRoundOne);
            firstRoundScores.add(playerTwoScoreRoundOne);
            finalScores.add(playerOneScoreRoundOne);
            finalScores.add(playerTwoScoreRoundOne);

            //send firstroundscores to client
            objectOutputPlayerOne.writeObject(firstRoundScores);
            objectOutputPlayerTwo.writeObject(firstRoundScores);

            questionCounter = 0;

            //NEW round executed
            //sending player titles
            /*objectOutputPlayerOne.writeObject(player1);
            objectOutputPlayerTwo.writeObject(player2);

            //waiting window
            objectOutputPlayerOne.writeObject(playingInProgress);
            objectOutputPlayerTwo.writeObject(playingInProgress);*/

            //category window
            objectOutputPlayerOne.writeObject(q.myCategories());
            objectOutputPlayerTwo.writeObject(q.myCategories());

            //player two chooses category this round
            chosenCategoryRoundTwo = inPlayerOne.readLine();

            //send quiz questions to player one and two
            if (chosenCategoryRoundTwo.equalsIgnoreCase("historia")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.historyCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategoryRoundTwo.equalsIgnoreCase("naturvetenskap")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategoryRoundTwo.equalsIgnoreCase("spel")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }

            } else if (chosenCategoryRoundTwo.equalsIgnoreCase("musik")) {
                while (questionCounter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }
                questionCounter = 0;
                while (questionCounter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    questionCounter++;
                }

            }

            finalScores.add(playerOneScoreRoundTwo);
            finalScores.add(playerTwoScoreRoundTwo);
            //final scores of all rounds sent to client
            objectOutputPlayerOne.writeObject(finalScores);
            objectOutputPlayerTwo.writeObject(finalScores);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
