/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        gameBoard = new GameBoard();
        // player1 starts the game
        // create a new scanner and game board
        scanner = new Scanner(System.in);
        gameBoard = new GameBoard();
        // read out player names and give them their respective symbols
        System.out.println("What is player 1's name? ");
        String name1 = scanner.nextLine();
        // player1's name and symbol will be stored into new player object
        player1 = new Player(name1, 'X');
        // do the same process for player 2
        System.out.println("What is player 2's name? ");
        String name2 = scanner.nextLine();
        player2 = new Player(name2, 'O');

        // since player 1 starts the game, assign player1 to current player
        currentPlayer = player1;
    }

    // NO NEED TO TOUCH startGame()
    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameBoard.printBoard();
            promptPlayerMove();
            if (gameBoard.checkWin()) {
                gameBoard.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (gameBoard.isFull()) {
                gameBoard.printBoard();
                System.out.println("The game ended in a tie!");
                gameEnded = true;
            } else {
                switchPlayers();
            }
        }
        scanner.close();
    }

    // Prompts the player to place a move and checks for its validity
    private void promptPlayerMove() {
        boolean validMove = false;
        while (!validMove) {
            try {
            // iterates as long as a move is valid
            System.out.print(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.println(" Enter row (0, 1, or 2): ");
            int row = scanner.nextInt();
            System.out.println("Enter column (0, 1, or 2): ");
            int col = scanner.nextInt();
            // add a scanner.nextLine() to stop any error that may happen
            scanner.nextLine();

             // Check whether the move is valid, if not, ask the player to place a move again
            // If the player's move is valid, the move is placed on the gameBoard
            // create if else statement to check validity of move
            if (row >= 0 && row < GameBoard.SIZE && col >= 0 && col < GameBoard.SIZE) {
                validMove = gameBoard.makeMove(row, col, currentPlayer.getSymbol());
                if (!validMove) {
                    System.out.println("Cell is already filled. Select an empty space.");
                }
            } else {
                System.out.println("Invalid input. Please enter a row and column between 0 and 2.");
            }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                // clear the invalid input from the scanner
                scanner.nextLine();
            }
        }  
     }

    

    // Switch players
    // Sets the player that is not the currentPlayer as currentPlayer
    private void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
