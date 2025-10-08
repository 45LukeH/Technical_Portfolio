/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class GameBoard {
    // initialize the 2D array
    private char[][] board;


    // 'final' means that SIZE is a constant and cannot be changed after initialization
    // Java convention: Constants in Java are written in all upper-case letters
    // The size indicates the gameboard size (3x3)
    public static final int SIZE = 3;

    public GameBoard() {
        // initialize the board and set empty space characters '-'
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // makeMove marks a non-empty cell with the respective symbol
    public boolean makeMove(int row, int col, char symbol) {
        if (board[row][col] == '-') {
            // place a player's x or o
            board[row][col] = symbol;
            return true;
        }
        return false;
        // it returns false only if a spot is already occupied
    }

    // Checks if a player has placed three symbols in a row, column, or diagonal
    // If yes, that player has won
    
    public boolean checkWin() {
        // Hint: Define additional methods to keep your code organized and readable!
        return checkRows() || checkColumns() || checkDiagonals();
    }
    private boolean checkRows() {
        // iterate through the rows to see if all symbols match
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }
        return false;
    }  

        // this method is the same as checkRows() except we reverse the way the array is read
    private boolean checkColumns() {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        return false;
    }
    
        // checkDiagonals mostly follows the same logic as the other 2 methods
        // except 2 if statements are needed to check for both diagonals
    private boolean checkDiagonals() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }
        
        
    

    // Checks if the gameboard is full but no player won
    public boolean isFull() {
        // iterates through the array to make sure it is not filled
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        // this will print the current game board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // this will print each cell with padding
                System.out.printf(" %c ", board[i][j]);
                if (j < SIZE - 1) {
                    // print vertical separators
                    System.out.print("|");
                }
            }
            // this print statement will move it to the next line after the first row is printed
            System.out.println();
            if (i < SIZE - 1) {
                // print the horizontal separators
                System.out.println("---+---+---");
            }
        }
    }
}
