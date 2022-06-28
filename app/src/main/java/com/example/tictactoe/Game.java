package com.example.tictactoe;

import java.util.ArrayList;

public class Game {
    Character player;
    int turn;
    ArrayList<Character> board;

    Game() {
        player = 'x';
        turn = 0;
        board = new ArrayList<>(9);
        for (int i=0; i<9; i++)
            board.add(String.valueOf(i).charAt(0));
    }

    void nextTurn() {
        player = player.equals('x') ? 'o' : 'x';
        turn++;
    }

    public void registerTurn(int cell) {
        board.set(cell, player);
        nextTurn();
    }

    Character getWinner() {
        if (turn >= 9)
            return 't';
        for (int i=0; i<3; i++) {
            if (board.get(3*i).equals(board.get(3*i+1)) && board.get(3*i).equals(board.get(3*i+2)))
                return board.get(3*i);
            if (board.get(i).equals(board.get(i+3)) && board.get(i).equals(board.get(i+6)))
                return board.get(i);
        }

        if (board.get(0).equals(board.get(4)) && board.get(0).equals(board.get(8)))
            return board.get(0);
        if (board.get(2).equals(board.get(4)) && board.get(2).equals(board.get(6)))
            return board.get(2);

        return null;
    }
}
