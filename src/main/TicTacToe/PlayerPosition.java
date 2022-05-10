package main.TicTacToe;

import java.util.ArrayList;

public enum PlayerPosition {
    A(0,0,'A'),
    B(0,1,'B'),
    C(0,2,'C'),
    D(1,0,'D'),
    E(1,1,'E'),
    F(1,2,'F'),
    G(2,0,'G'),
    H(2,1,'H'),
    I(2,2,'I');


    private int x;
    private int y;

    private char symbol;

    PlayerPosition(int x, int y, char symbol) {
            this.x = x ;
            this.y = y ;
            this.symbol = symbol;
        }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }
}
