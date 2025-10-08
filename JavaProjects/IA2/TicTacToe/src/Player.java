/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class Player {
    // initialize the variables for Player
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    // add the getters since we enxapsulated the variables
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
}
