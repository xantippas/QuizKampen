import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {

    int counter = 0;

    List<Integer> scores = new ArrayList<>();
    List<Integer> finalScores = new ArrayList<>();

    int playerOneScoreRoundOne = 0;
    int playerTwoScoreRoundOne = 0;
    int playerOneScoreRoundTwo = 0;
    int playerTwoScoreRoundTwo = 0;
    PrintWriter outPlayerOne;
    BufferedReader inPlayerOne;
    PrintWriter outPlayerTwo;
    BufferedReader inPlayerTwo;
    String response;
    String chosenCategory;
    String playingInProgress = "Game is starting";

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
            //starting window
            objectOutputPlayerOne.writeObject(playingInProgress);
            objectOutputPlayerTwo.writeObject(playingInProgress);

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
                        System.out.println(response);
                        counter++;
                    }
                    counter = 0;
                    while (counter < 4) {
                        objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                        response = inPlayerTwo.readLine();
                        playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                        System.out.println(response);
                        counter++;
                    }

                } else if (chosenCategory.equalsIgnoreCase("science")) {
                    while (counter < 4) {
                        objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                        response = inPlayerOne.readLine();
                        playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                        System.out.println(response);
                        counter++;
                    }
                    counter = 0;
                    while (counter < 4) {
                        objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                        response = inPlayerTwo.readLine();
                        playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                        System.out.println(response);
                        counter++;
                    }

                } else if (chosenCategory.equalsIgnoreCase("gaming")) {
                    while (counter < 4) {
                        objectOutputPlayerOne.writeObject(q.gamingCategoryQs());
                        response = inPlayerOne.readLine();
                        playerOneScoreRoundOne = playerOneScoreRoundOne + Integer.parseInt(response);
                        System.out.println(response);
                        counter++;
                    }
                    counter = 0;
                    while (counter < 4) {
                        objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                        response = inPlayerTwo.readLine();
                        playerTwoScoreRoundOne = playerTwoScoreRoundOne + Integer.parseInt(response);
                        System.out.println(response);
                        counter++;
                    }

                }
                scores.add(playerOneScoreRoundOne);
                scores.add(playerTwoScoreRoundOne);

                System.out.println(scores);
                objectOutputPlayerOne.writeObject(scores);
                objectOutputPlayerTwo.writeObject(scores);

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //counter++;


            //NEW ROUND not setup in client
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
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.historyCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("science")) {
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.scienceCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerOne.writeObject(q.scienceCategoryQs());
                    response = inPlayerOne.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }

            } else if (chosenCategory.equalsIgnoreCase("gaming")) {
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerOneScoreRoundTwo = playerOneScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }
                counter = 0;
                while (counter < 4) {
                    objectOutputPlayerTwo.writeObject(q.gamingCategoryQs());
                    response = inPlayerTwo.readLine();
                    playerTwoScoreRoundTwo = playerTwoScoreRoundTwo + Integer.parseInt(response);
                    System.out.println(response);
                    counter++;
                }

            }
            finalScores.add(playerOneScoreRoundOne);
            finalScores.add(playerTwoScoreRoundOne);
            finalScores.add(playerOneScoreRoundTwo);
            finalScores.add(playerTwoScoreRoundTwo);

            System.out.println(finalScores);
            objectOutputPlayerOne.writeObject(finalScores);
            objectOutputPlayerTwo.writeObject(finalScores);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
