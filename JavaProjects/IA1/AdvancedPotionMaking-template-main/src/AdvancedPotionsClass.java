/*
 * Created on 2024-09-17
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Scanner;

public class AdvancedPotionsClass {
    
    private static Scanner scanner = new Scanner(System.in);

    // TODO: Add new ingredients
    //Creating new ingredient objects from the Ingredient constructor (String name, int potencyEffect)
    private static Ingredient bicornHorn = new Ingredient ("Bicorn Horn", 7);
    private static Ingredient dragonBlood = new Ingredient ("Dragon Blood", 10);
    private static Ingredient hornedToad = new Ingredient ("Horned Toad", 4);
    private static Ingredient octopusPowder = new Ingredient ("Octopus Powder", 6);
    private static Ingredient silverweed = new Ingredient ("Silverweed", 0);

    public static void main(String[] args) {

        // TODO: Create a new potion
        Potion potion = new Potion();
        // create a new Cauldron Event object called ruin to call after potion is evaluated
        CauldronEvent ruin = new CauldronEvent();

        // TODO: Prompt the user about ingredient options
        int totalPotency = selectIngredients(potion);
        System.out.println("Total potency: " + totalPotency);
        // TODO: Prompt the user to stir and heat the potion
        stirPotion(potion);
        heatPotion(potion);
        // TODO: Evaluate the potion and print the result 
        potion.evaluatePotion();
        scanner.close();
        ruin.triggerEvent();
    }
    

    // TODO: Implement selectIngredients(...)
    // Allow the user to choose ingredients
    // Prompt the user again for invalid choices
    public static int selectIngredients(Potion potion) {
        System.out.println("Select 4 ingredients for your potion: ");
        System.out.println("1: " + bicornHorn.getName() + " (Potency: " + bicornHorn.getPotencyEffect() + ")");
        System.out.println("2: " + dragonBlood.getName() + " (Potency: " + dragonBlood.getPotencyEffect() + ")");
        System.out.println("3: " + hornedToad.getName() + " (Potency: " + hornedToad.getPotencyEffect() + ")");
        System.out.println("4: " + octopusPowder.getName() + " (Potency: " + octopusPowder.getPotencyEffect() + ")");
        System.out.println("5: " + silverweed.getName() + " (Potency: " + silverweed.getPotencyEffect() + ")");

        int successfulIterations = 0; //counts the successful iterations
        while (true) {
            System.out.print("Enter the number corresponding to the ingredient: ");
           // This is the check if the input is an integer
            if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            // This if statement will break the loop when the user is done selecting ingredients
          
            switch (choice) {
                case 1:
                    potion.addIngredient(bicornHorn.getPotencyEffect());
                    System.out.println("You added: " + bicornHorn.getName());
                    successfulIterations++; //Increments successfulIterations by 1 for each successful ingredient selected
                    break;
                case 2:
                    potion.addIngredient(dragonBlood.getPotencyEffect());
                    System.out.println("You added: " + dragonBlood.getName());
                    successfulIterations++;
                    break;
                case 3:
                    potion.addIngredient(hornedToad.getPotencyEffect());
                    System.out.println("You added: " + hornedToad.getName());
                    successfulIterations++;
                    break;
                case 4:
                    potion.addIngredient(octopusPowder.getPotencyEffect());
                    System.out.println("You added: " + octopusPowder.getName());
                    successfulIterations++;
                    break;
                case 5:
                    potion.addIngredient(silverweed.getPotencyEffect());
                    System.out.println("You added: " + silverweed.getName());
                    successfulIterations++;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            if (successfulIterations == 4) {
                break;
            }
    // I learned about how to use switch statements at https://www.w3schools.com/java/java_switch.asp
            } else {
                System.out.println("Invalid input. Please enter the number corresponding to the ingredient.");
                scanner.nextLine();
            }
        }
        return potion.getPotencyEffect();
    }
    
    // TODO: Implement stirPotion(...)
    // to prompt the user on how often they would like to stir the potion
    // Then stir the potion as many times
        public static void stirPotion(Potion potion) {
            System.out.println("How many times would you like to stir the potion? (1-3) ");
            int stirCount = scanner.nextInt();
            for (int i = 0; i < stirCount; i++) {
                potion.stirPotion();
            }
        }
    // TODO: Implememt heatPotion(...)
    // That prompts the user to input the heat level of the potion
        public static void heatPotion(Potion potion) {
            System.out.println("What heat level would you like to apply to the potion? (1-3) ");
            int heatLevel = scanner.nextInt();
            for (int i = 0; i < heatLevel; i++) {
                potion.heatPotion();
            }
        }
       
    }
    