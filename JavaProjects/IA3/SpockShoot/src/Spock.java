// all other choices subclasses can be copy and pasted from
// rock with minor changes
/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */


// make sure rock and all other choices extends choice
public class Spock extends Choice{

    // TODO Implement a specific version of getName() for each choice
    // Hint: Make use of GameChoices to get a nice representation of the name!
    @Override
    public String getName() {
        return GameChoices.SPOCK.toString();
    }


    // TODO Implement a specific version of competeExplanation() for each choice
    // Should return a String of the game round's explanation (e.g., "Rock crushes
    // Lizard")
    @Override
    public String competeExplanation(Choice otherPlayerChoice) {
        // i figure I can use 4 if statements that returns the outcome
        if (otherPlayerChoice instanceof Scissors) return "Spock smashes Scissors";
        if (otherPlayerChoice instanceof Rock) return "Spock vaporizes Rock";
        if (otherPlayerChoice instanceof Paper) return "Paper disproves Spock";
        if (otherPlayerChoice instanceof Lizard) return "Lizard poisons Spock";
        // if the other player chooses spock, it results in a tie
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
        if (otherPlayerChoice instanceof Scissors || otherPlayerChoice instanceof Rock) {
            return 1; // spock wins
        } else if (otherPlayerChoice instanceof Spock) {
            return 0; // no win or loss - tie
        } else {
            return -1; // spock loses
        }
    }
}
