/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */
// make sure rock and all other choices extends choice


public class Paper extends Choice{

    // TODO Implement a specific version of getName() for each choice
    // Hint: Make use of GameChoices to get a nice representation of the name!
    @Override
    public String getName() {
        return GameChoices.PAPER.toString();
    }


    // TODO Implement a specific version of competeExplanation() for each choice
    // Should return a String of the game round's explanation (e.g., "Rock crushes
    // Lizard")
    @Override
    public String competeExplanation(Choice otherPlayerChoice) {
        // i figure I can use 4 if statements that returns the outcome
        if (otherPlayerChoice instanceof Rock) return "Paper covers Rock";
        if (otherPlayerChoice instanceof Spock) return "Paper disproves Spock";
        if (otherPlayerChoice instanceof Scissors) return "Scissors cut Paper";
        if (otherPlayerChoice instanceof Lizard) return "Lizard eats Paper";
        // if the other player chooses paper, it results in a tie
        return "It's a tie!";
    }

    // TODO Implement a specific version of determineWin() for each choice
    /*
     * Compares the choice with the other player's choice
     * - Should return an `int`:
     * - `0`: choice is equal to otherPlayerChoice
     * - `1`: choice wins agains otherPlayerChoice
     * - `-1`: choice looses to otherPlayerChoice
     */
    @Override
    public int determineWin(Choice otherPlayerChoice) {
        if (otherPlayerChoice instanceof Rock || otherPlayerChoice instanceof Spock) {
            return 1; // paper wins
        } else if (otherPlayerChoice instanceof Paper) {
            return 0; // no win or loss - tie
        } else {
            return -1; // paper loses
        }
    }
}
