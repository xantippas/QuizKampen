package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread{

    Thread aktivitet = new Thread(this);
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    List<String> myList = new ArrayList<>();
    Socket socket;

    public Game(Player player1, Player player2, Player player3, Player player4){
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.socket = player1.getSocket();
        aktivitet.start();
    }

    @Override
    public void run(){

    }

}
