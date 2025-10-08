/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */


import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

    private Player player;
    private Player computer;

    private final int minWins = 2;
    // track player and computer wins
    private int playerWins = 0;
    private int computerWins = 0;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    protected RockPaperScissorsLizardSpock() {
        System.out.println("Player 1, please enter your name:");
        player = new Player(scanner.nextLine());
        System.out.println();
        computer = new Player("Computer");
    }

    // TODO: implement playRound and round win check here
    public void playRound() {
        System.out.printf(player.getName() + ", please enter %s, %s, %s, %s, or %s: %n", GameChoices.ROCK, GameChoices.PAPER,
                GameChoices.SCISSORS, GameChoices.LIZARD, GameChoices.SPOCK);
        // ...
        String playerInput = scanner.nextLine();
        Choice playerChoice = getChoice(playerInput);
        
        if (playerChoice == null) {
            System.out.println("Invalid choice, try again.");
            return; // stop the round if the input is invalid
        }
        //display the computer's choice
        Choice computerChoice = getRandomChoice();
        System.out.println(computer.getName() + " selects " + computerChoice.getName());

        // compare the two choices
        int result = playerChoice.compete(computerChoice);

        // display the outcome of the round with an if/else statement
        if (result == 0) {
            System.out.println("Tie!");
        } else if (result == 1) {
            System.out.println("Round result: " + player.getName() + " wins this round!");
            playerWins++;
        } else {
            System.out.println("Round result: " + computer.getName() + " wins this round!");
            computerWins++;
        }
        // display an explanation of the round's outcome
        //System.out.println(playerChoice.competeExplanation(computerChoice));
        System.out.println();
    }

    // TODO: implement a method to convert the player's input into a choice
    private Choice getChoice(String choice) {
        choice = choice.toLowerCase();
        // Check the passed string and return a Choice object (i.e., Rock, Paper, Scissors, Lizard, or Spock)
        // Pick a default case
        // ensure case does not matter for the word
        choice = choice.toLowerCase();
        // now implement switch case that will create new objects for whatever the user picks
        switch (choice) {
            case "rock":
                return new Rock();
            case "paper":
                return new Paper();
            case "scissors":
                return new Scissors();
            case "lizard":
                return new Lizard();
            case "spock":
                return new Spock();
            default:
                return null;
        }
    }

    // TODO: implement a method to get a random choice for the computer
    private Choice getRandomChoice() {
        // Based on a random number, return a Choice object (i.e., Rock, Paper, Scissors, Lizard, or Spock)
        // Pick a default case
        int randomChoice = random.nextInt(5);
        switch (randomChoice) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Scissors();
            case 3:
                return new Lizard();
            case 4:
                return new Spock();
            default:
                return new Rock(); // rock is the default choice
        }
    }

    // TODO: implement the main game loop and overall game win check here
    public void startGame() {
        // print statement to start the game
        System.out.println("Starting game. Win 2 out of 3 rounds to win the game!");
        // make sure the wins aren't above 2
        while (playerWins < minWins && computerWins < minWins) {
            playRound();
            // make a live counter so user can keep track of score
            System.out.println("Current score: " + player.getName() + " " + playerWins + " - Computer " + computerWins);
        }
        // once either player or computer gets 2 wins, display the winner with if/else
        if (playerWins > computerWins) {
            System.out.println(player.getName() + " wins!");
            System.out.println("Final score: " + player.getName() + ": " + playerWins +
            " vs Computer: " + computerWins);
        } else {
            System.out.println("Computer wins!");
            System.out.println("Final score: " + player.getName() + ": " + playerWins +
            " vs Computer: " + computerWins);
        }
    }

    // NO NEED TO TOUCH main()
    public static void main(String[] args) {
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock();
        game.startGame();
        game.scanner.close();
    }
}
