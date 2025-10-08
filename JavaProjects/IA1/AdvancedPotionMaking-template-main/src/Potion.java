/*
 * Created on 2024-09-17
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Random;

public class Potion {
    // TODO: Implement Potion. Add useful variables, methods, getters, setters, and constructor(s)
    // Hint: A potion should have a potency, stirring level, and heat level, as well as an indicator of whether it has been ruined
    // Ingredients do not need to be stored within the Potion class!
    private int potencyEffect;
    private int stirringLevel;
    private int heatLevel;
    private boolean isRuined;

    private Random random = new Random();

    // Implement default Potion constructor
    public Potion() {
        this.potencyEffect = 0;
        this.stirringLevel = 0;
        this.heatLevel = 0;
        this.isRuined = false;
    }

    // Add the getters
    public int getPotencyEffect() {
        return potencyEffect;
    }
    public int getStirringLevel() {
        return stirringLevel;
    }
    public int getHeatLevel() {
        return heatLevel;
    }
    public boolean getIsRuined() {
        return isRuined;
    }

    // Add the setters - I realized I didn't need them but keeping the code commented in case I need it later
    /*public void setPotencyEffect(int potencyEffect) {
        this.potencyEffect = potencyEffect;
    }
    public void setStirringLevel(int stirringLevel) {
        this.stirringLevel = stirringLevel;
    }
    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }*/

    // TODO: Implement addIngredient(...) 
    // The ingredient's potency effect should be added to the potion's potency
    public void addIngredient(int ingredientPotency) {
        if (!isRuined) {
            this.potencyEffect += ingredientPotency;
        }
    }
    
    // TODO: Implement stirPotion(...) 
    // Stir the potion with a random effect: add a random value between 1 and 5
    public void stirPotion() {
        if (!isRuined) {
            int stirEffect = random.nextInt(5) + 1;
            this.stirringLevel += stirEffect;
            System.out.println("Your potion has been stirred, effect: " + stirEffect + ", current stirring level: " + stirringLevel);
        }
    }

    // TODO: Implement heatPotion(...) 
    // Heat the potion with a random effect: add a random value between 0 and 7
    public void heatPotion() {
        if (!isRuined) {
            int heatEffect = random.nextInt(8);
            this.heatLevel += heatEffect;
            System.out.println("Your potion has been heated, effect: " + heatEffect + ", current heat level: " + heatLevel);
        }
    }
    
    // TODO: Implement evaluatePotion(...) 
    public void evaluatePotion() {
        System.out.println("Evaluating potion...");
        if (!isRuined) {
            if (potencyEffect > 15 && stirringLevel > 5 && heatLevel > 3) {
                System.out.println("The potion has been brewed perfectly!");
            }else if (potencyEffect <= 15 && potencyEffect > 10 && stirringLevel > 3 && heatLevel > 3) {
                System.out.println("The potion is a bit unstable but it will do.");
            }else {
                System.out.println("The potion is ruined.");
                isRuined = true;
            }
        }else {
            System.out.println("The potion was already ruined.");
        }
    }
    // I used the criteria below to carve out the if-else statement
    /* Criteria: 
     * If the potion is not ruined, and its potency is greater than 15, the stirring level is greater than 5,
     * and the heat level is greater than 3, it is brewed perfectly
     * If the potion is not ruined and its potency is less than 15 but greater than 10,
     * the stirringLevel is greater than 3 and the heatLevel is greater than 3, the potion is a bit unstable but ok
     * Otherwise, the potion is ruined.
     */ 

}
