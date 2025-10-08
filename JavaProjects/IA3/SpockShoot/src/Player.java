/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */


 public final class Player {
    // TODO: implement.
    private String name;
    private int wins; // tracks a player's win count

    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
    //make a method that increments wins when a player wins
    public void incrementWins() {
        wins++;
    }
}
