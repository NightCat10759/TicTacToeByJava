package main.TicTacToe;

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

    public void judge(Player player){
        if (player.wining()){
            System.out.println("do you wanna try again?");
            String answer = input.nextLine();
            if (answer.equals("No")){
                exit();
            } else {
                // 清空數據和板子
                player.reset();
                initBoard();
            }
        }
    }
}
