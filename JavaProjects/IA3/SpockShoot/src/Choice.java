/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// TODO: implement Choice
// Choice should function as the Base class for all the choices
// There is no default Choice!

// Rock was already partially implemented as an example
// You may make changes to the structure and type of both classes!


// make the class abstract
public abstract class Choice {

    // create abstract methods getName(), determineWin(), and competeExplanation(),
    public abstract String getName();

    public abstract int determineWin(Choice otherPlayerChoice);

    public abstract String competeExplanation(Choice otherPlayerChoice);


    // NO NEED TO TOUCH compete()
    public int compete(Choice otherPlayerChoice) {
        System.out.println("Outcome: " + competeExplanation(otherPlayerChoice));
        return determineWin(otherPlayerChoice);
    }
}
