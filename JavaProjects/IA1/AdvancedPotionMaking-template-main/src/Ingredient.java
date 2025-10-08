/*
 * Created on 2024-09-17
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class Ingredient {
    private String name;
    private int potencyEffect;
    // TODO: Implement Ingredient. Add useful variables, methods, getters, setters, and constructor(s)
    // Hint: An ingredient has a name and a potency effect that should be max. 10
    // Declaring a parameterized constructor
    public Ingredient (String name, int potencyEffect) {
        this.name = name;
        // We need to add an if else loop to make sure potency is between 1 and 10
        // If it goes under 10 or below 0, it will automatically be set to 10 or 0
        if (potencyEffect > 10) {
            this.potencyEffect = 10;
        }else if (potencyEffect < 0) {
            this.potencyEffect = 0;
        }else {
            this.potencyEffect = potencyEffect;
        }
    

    }
    // Add getters for name and potencyEffect
    public String getName() {
        return name;
    } 
    public int getPotencyEffect() {
        return potencyEffect;
    }
    // Add a setter for potencyEffect - I have been writing setters as a habit, but they are not needed for this.
    /*public void setPotencyEffect(int potencyEffect) {
        if (potencyEffect > 10) {
            this.potencyEffect = 10;
        }else if (potencyEffect < 0) {
            this.potencyEffect = 0;
        }else {
            this.potencyEffect = potencyEffect;
        }
    }*/
}
