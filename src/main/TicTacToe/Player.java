package main.TicTacToe;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    Scanner input = new Scanner(System.in);
    private String name;
    private ArrayList<PlayerPosition> all_symbol_position = new ArrayList<>();

    private char chess;

    private static int people = 0;
    private int score = 0;

    public Player(){
        this.people ++;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }

    public void action(TicTacToe game){
        while(true){
            System.out.println("\n" + getName() + " action:(A,B,C....I)");
            String action = input.nextLine();
            if ( !action.matches("[A-I]")){
                System.out.println("Please Input A~I");
            } else {
                char[][] board = game.getBoard();
                if(!place(game.getBoard(),action.charAt(0))){
                    continue;
                }
                break;
            }
        }
    }


    public boolean positionIsEmpty(char boardValue){
        if (boardValue != '-'){
            System.out.println("Cant not replaced!");
            return false;
        }
        return true;
    }

    public boolean place(char[][] board,char action){

        // 0 , 0
        // all_symbol_position = 0
        if (action == 'A'){
            if (!positionIsEmpty(board[PlayerPosition.A.getX()][PlayerPosition.A.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.A);
            board[PlayerPosition.A.getX()][PlayerPosition.A.getY()] = getChess();
        }

        // 0 , 1
        // all_symbol_position = 1
        if (action == 'B'){
            if (!positionIsEmpty(board[PlayerPosition.B.getX()][PlayerPosition.B.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.B);
            board[PlayerPosition.B.getX()][PlayerPosition.B.getY()] = getChess();
        }

        // 0 , 2
        // all_symbol_position = 2
        if (action == 'C'){
            if (!positionIsEmpty(board[PlayerPosition.C.getX()][PlayerPosition.C.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.C);
            board[PlayerPosition.C.getX()][PlayerPosition.C.getY()] = getChess();
        }

        // 1 , 0
        // all_symbol_position = 3
        if (action == 'D'){
            if (!positionIsEmpty(board[PlayerPosition.D.getX()][PlayerPosition.D.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.D);
            board[PlayerPosition.D.getX()][PlayerPosition.D.getY()] = getChess();
        }

        // 1 , 1
        // all_symbol_position = 4
        if (action == 'E'){
            if (!positionIsEmpty(board[PlayerPosition.E.getX()][PlayerPosition.E.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.E);
            board[PlayerPosition.E.getX()][PlayerPosition.E.getY()] = getChess();
        }

        // 1 , 2
        // all_symbol_position = 5
        if (action == 'F'){
            if (!positionIsEmpty(board[PlayerPosition.F.getX()][PlayerPosition.F.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.F);
            board[PlayerPosition.F.getX()][PlayerPosition.F.getY()] = getChess();
        }

        // 2 , 0
        // all_symbol_position = 6
        if (action == 'G'){
            if (!positionIsEmpty(board[PlayerPosition.G.getX()][PlayerPosition.G.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.G);
            board[PlayerPosition.G.getX()][PlayerPosition.G.getY()] = getChess();
        }

        // 2 , 1
        // all_symbol_position = 7
        if (action == 'H'){
            if (!positionIsEmpty(board[PlayerPosition.H.getX()][PlayerPosition.H.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.H);
            board[PlayerPosition.H.getX()][PlayerPosition.H.getY()] = getChess();
        }

        // 2 , 2
        // all_symbol_position = 8
        if (action == 'I'){
            if (!positionIsEmpty(board[PlayerPosition.I.getX()][PlayerPosition.I.getY()])){
                return false;
            }
            all_symbol_position.add(PlayerPosition.I);
            board[PlayerPosition.I.getX()][PlayerPosition.I.getY()] = getChess();
        }
        return true;
    }

    public void winingMessage(){
        System.out.println("\n" + this.name + " Winning!!");
    }
    public boolean wining(){
        // A B C
        if (all_symbol_position.contains(PlayerPosition.A)){
            if (all_symbol_position.contains(PlayerPosition.B)){
                if (all_symbol_position.contains(PlayerPosition.C)){
                    winingMessage();
                    return true;
                }
            }
        }
        // D E F
        if (all_symbol_position.contains(PlayerPosition.D)){
            if (all_symbol_position.contains(PlayerPosition.E)){
                if (all_symbol_position.contains(PlayerPosition.F)){
                    winingMessage();
                    return true;
                }
            }
        }
        // G H I
        if (all_symbol_position.contains(PlayerPosition.G)){
            if (all_symbol_position.contains(PlayerPosition.H)){
                if (all_symbol_position.contains(PlayerPosition.I)){
                    winingMessage();
                    return true;
                }
            }
        }
        // A D G
        if (all_symbol_position.contains(PlayerPosition.A)){
            if (all_symbol_position.contains(PlayerPosition.D)){
                if (all_symbol_position.contains(PlayerPosition.G)){
                    winingMessage();
                    return true;
                }
            }
        }
        // B E H
        if (all_symbol_position.contains(PlayerPosition.B)){
            if (all_symbol_position.contains(PlayerPosition.E)){
                if (all_symbol_position.contains(PlayerPosition.H)){
                    winingMessage();
                    return true;
                }
            }
        }
        // C F I
        if (all_symbol_position.contains(PlayerPosition.C)){
            if (all_symbol_position.contains(PlayerPosition.F)){
                if (all_symbol_position.contains(PlayerPosition.I)){
                    winingMessage();
                    return true;
                }
            }
        }
        // A E I
        if (all_symbol_position.contains(PlayerPosition.A)){
            if (all_symbol_position.contains(PlayerPosition.E)){
                if (all_symbol_position.contains(PlayerPosition.I)){
                    winingMessage();
                    return true;
                }
            }
        }
        // C E G
        if (all_symbol_position.contains(PlayerPosition.C)){
            if (all_symbol_position.contains(PlayerPosition.E)){
                if (all_symbol_position.contains(PlayerPosition.G)){
                    winingMessage();
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.printf( "\n Player %d input your name:",this.people);
        name = input.nextLine();
        this.name = name;
    }

    public char getChess() {
        return chess;
    }

    public void setChess() {
        System.out.printf( "\n"+ getName() +" input your chess:");
        char chess = input.nextLine().charAt(0);
        this.chess = chess;
    }

    public ArrayList<PlayerPosition> getAll_symbol_position() {
        return all_symbol_position;
    }

    public void reset(){
        all_symbol_position.clear();
        System.out.println(all_symbol_position);
    }

    public void showinfo(){
        System.out.println("Player: " + getName() + getChess());
    }
}
