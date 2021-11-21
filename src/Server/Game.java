package Server;

import Client.MainMenu;
import Client.QuizPanel;

import javax.swing.*;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread{

    MainMenu menu = new MainMenu();

    JFrame frame = new JFrame();

    Player currentplayer;
    Player opponent;
    Socket socket;

    public Game(Player player1, Player player2){
        this.currentplayer=player1;
        this.opponent=player2;
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

    @Override
    public void run(){


    }



}
