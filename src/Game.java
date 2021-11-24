import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {

    int counter = 0;
    int rounds = 0; //do we need this??

    List<Integer> scores = new ArrayList<>();
    List<Integer> finalScores = new ArrayList<>();

    PrintWriter outPlayerOne;
    BufferedReader inPlayerOne;
    PrintWriter outPlayerTwo;
    BufferedReader inPlayerTwo;
    String response;
    String chosenCategory;
    String chosenCategory2;
    String playingInProgress = "Välkommen till Quizkampen, Player 1 börjar...";
    String player1 = "Player 1";
    String player2 = "Player 2";

    OutputStream osPlayerOne;
    ObjectOutputStream objectOutputPlayerOne;

    OutputStream osPlayerTwo;
    ObjectOutputStream objectOutputPlayerTwo;

    //input streams
    InputStream getObjectFromServerPlayerOne;
    ObjectInputStream objectInputPlayerOne;

    InputStream getObjectFromServerPlayerTwo;
    ObjectInputStream objectInputPlayerTwo;

    Socket playerOne;
    Socket playerTwo;

    DatabaseOfQuestions q = new DatabaseOfQuestions();

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
            objectOutputPlayerOne.writeObject(playingInProgress);
            objectOutputPlayerTwo.writeObject(playingInProgress);

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
            if (chosenCategory.equalsIgnoreCase("history")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.historyCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("science")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("gaming")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("music")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.musicCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.musicCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                    counter++;
                }

            }
            scores.add(playerOneScoreRoundOne);
            scores.add(playerTwoScoreRoundOne);
            finalScores.add(playerOneScoreRoundOne);
            finalScores.add(playerTwoScoreRoundOne);

            //send firstroundscores to client
            objectOutputPlayerOne.writeObject(scores);
            objectOutputPlayerTwo.writeObject(scores);

            counter = 0;

            //NEW round executed
            //sending player titles
            objectOutputPlayerOne.writeObject(player1);
            objectOutputPlayerTwo.writeObject(player2);

            //waiting window
            objectOutputPlayerOne.writeObject(playingInProgress);
            objectOutputPlayerTwo.writeObject(playingInProgress);

            //category window
            objectOutputPlayerOne.writeObject(q.myCategories());
            objectOutputPlayerTwo.writeObject(q.myCategories());

            //player two chooses category this round
            chosenCategory2 = inPlayerOne.readLine();

            //send quiz questions to player one and two
            if (chosenCategory2.equalsIgnoreCase("history")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.historyCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory2.equalsIgnoreCase("science")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory2.equalsIgnoreCase("gaming")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }

            } else if (chosenCategory2.equalsIgnoreCase("music")) {
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                    response = inPlayerOne.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    counter++;
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
