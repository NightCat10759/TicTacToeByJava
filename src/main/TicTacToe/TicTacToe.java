package main.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    Scanner input = new Scanner(System.in);
    private int height;
    private int width;
    private char[][] board;
    protected char[][] testBoard = new char[][] {
        new char[] {'A','B','C'},
        new char[] {'D','E','F'},
        new char[] {'G','H','I'}
    };

    public TicTacToe() {
        this.height = 3;
        this.width = 3;
        initBoard();
        this.board = board;
    }
    public void initBoard(){
        this.board = new char[][] {
                new char[] {'-','-','-'},
                new char[] {'-','-','-'},
                new char[] {'-','-','-'}
        };
    }
    public boolean exit(){
        return false;
    }

    public void showBoard(){
        System.out.println("play board:");
        int first = 0;
        int second = 0;
        for (int width = 0; width < getWidth() * getHeight() +1; width++) {
            second = width % getWidth();
            if( (width != 0 ) && (width % getWidth())== 0 ){
                System.out.print("           ");
                for (int testwidth = 0; testwidth < getWidth(); testwidth++) {
                    System.out.print("|" + testBoard[first][testwidth] + "|");
                }
                first ++;
                System.out.println("\n-----------");
            }
            if(first > 2){
                break;
            }
            System.out.print("|" + board[first][second] + "|");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void help(){
        System.out.println("\n\nexample:");
        int first = 0;
        int second = 0;
        for (int i = 0; i < 9; i++) {
            second = i % 3;
            if( (i !=0 ) && (i % 3)== 0 ){
                first ++;
                System.out.println("\n-----------");
            }
            System.out.print("|" + testBoard[first][second] + "|");
        }
    }

    public boolean checkfilled(Player player1, Player player2){
        ArrayList<PlayerPosition> player1Position = player1.getAll_symbol_position();
        ArrayList<PlayerPosition> player2Position = player2.getAll_symbol_position();

        if ( (player1Position.size() + player2Position.size()) == this.getHeight() * this.getWidth() ) {
            return true;
        }
        return false;
    }

    public boolean judge(Player player1, Player player2){

        if (checkfilled(player1, player2)){
            showBoard();
            if (!tryAgain(player1, player2)){
                return true;
            }
        }

        if (player1.wining() || player2.wining()){
            if(player1.wining()){
                player1.addScore();
            }
            if(player2.wining()){
                player2.addScore();
            }
            showBoard();
            System.out.println(player1.getName() + " score is: " + player1.getScore());
            System.out.println(player2.getName() + " score is: " + player2.getScore());
            if (!tryAgain(player1, player2)){
                return true;
            }
        }
        return false;
    }

    public boolean tryAgain(Player player1, Player player2){
        System.out.println("do you wanna try again?(any or NO)");
        String answer = input.nextLine();
        answer = answer.toUpperCase();
        System.out.println("answer: " + answer);
        if (answer.equals("NO")){
            System.out.println("Thanks for playing!!");
            return exit();
        } else {
            System.out.println("Reset the score and table.");
            // 清空數據和板子
            player1.reset();
            player2.reset();
            initBoard();
            return true;
        }
    }
}
