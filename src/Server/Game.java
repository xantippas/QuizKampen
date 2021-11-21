package Server;

import Client.MainMenu;
import Client.QuizPanel;

import javax.swing.*;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game {

    MainMenu menu = new MainMenu();

    JFrame frame = new JFrame();

    Player currentplayer;
    Player opponent;
    Socket socket;

    public Game(){
        /*this.currentplayer=player1;
        this.opponent=player2;*/
    }

    //when client is started
    public void createPlayers(){

    }

    //searching for opponent
    public void searchAnotherPlayer(){

    }

    //
    public void showCurrentGameStatus(){

    }

    public Player getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(Player currentplayer) {
        this.currentplayer = currentplayer;
    }
}
