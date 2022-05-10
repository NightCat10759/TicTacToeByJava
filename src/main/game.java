package main;

import main.TicTacToe.Player;
import main.TicTacToe.PlayerPosition;
import main.TicTacToe.TicTacToe;

import java.util.*;

public class game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        Player Player1 = new Player();
        Player1.setName();
        Player1.setChess();

        Player Player2 = new Player();
        Player2.setName();
        Player2.setChess();


        while(true){
            game.showBoard();

            Player1.action(game);

            game.judge(Player1);

            game.showBoard();

            Player2.action(game);

            game.judge(Player2);

        }


    }
}
