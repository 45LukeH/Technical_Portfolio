# Assignment 3 - Rock-Paper-Scissors-Lizard-Spock

## Learning Objectives
You will gain a deeper understanding of OOP principles, specifically: inheritance, abstract classes (& polymorphism, see L20, _can also be solved without!_).

### Problem
**Rock-Paper-Scissors-Lizard-Spock** was invented by Sam Kass and Karen Bryla as a version of the classic selection method game Rock-Paper-Scissors that features **two** additional gestures: the **lizard** 🦎 (_hand as a sock-puppet-like mouth_) and Spock 🖖 (_Star Trek Vulcan salute_).

It's very simple:
Scissors cuts paper, paper covers rock, rock crushes Lizard, Lizard poisons Spock, Spock smashes scissors, scissors decapitates Lizard, Lizard eats paper, paper disproves Spock, Spock vaporizes rock, and (as it always has) rock crushes scissors.

### Your task
Your task is to implement this game in Java as a text-based game.

You can find and download the code template here.

## The Game

The game allows a human player to play against a computer player.

One round is played as follows:
1. The human player chooses their gesture (type of `Choice`).
2. The computer player chooses a random gesture (type of `Choice`)
3. The program checks for a win, loss, or draw of the round.

The game is played "best of 3", meaning that a player needs to win at least two rounds to win the game.

### Rules & Background
In the standard "rock-paper-scissors" gestures, each gesture defeats the one before it, and is defeated by the one after. 
If we add the two additional gestures after the word they '_rhyme_' with, the order is determined as:
1. Rock
2. Spock
3. Paper
4. Lizard
5. Scissors

Hence, the following rules can be derived:
- Scissors cut paper
- Paper covers rock
- Rock crushes lizard
- Lizard poisons Spock
- Spock smashes (or melts) scissors
- Scissors decapitate lizard
- Lizard eats paper
- Paper disproves Spock
- S vaporizes rock
- Rock breaks scissors


### **Game Requirements - Code**
*There are TODOs in the code. Make sure to follow them!*
* **`RockPaperScissorsLizardSpock`** represents the game.
* Each choice should do the following
  * `getName()`: Return a String with the choice's name (make use of `GameChoices`!)
  * `determineWin(otherPlayerChoice)`: compares the choice with the other player's choice
    * Should return an `int`:
      * `0`: choice is equal to otherPlayerChoice
      * `1`: choice wins agains otherPlayerChoice
      * `-1`: choice looses to otherPlayerChoice
  * `competeExplanation(otherPlayerChoice)`: should return a `String` of the game round's explanation (e.g., "Lizard poisons Spock")
* **Input Validation & Error Handling**: Make sure to add error and input validation checks!

### Important Considerations & Hints

- Please make sure to provide expressive comments, print statements, and variable names.
- **Make sure to follow object-oriented principles!**
- History of the game: http://www.samkass.com/theories/RPSSL.html
- You can play the basic version of the game here: https://www.rock-paper-scissors-game.com/
- Hints:
  - The operator `instanceof` can be used to check the type of an object (see https://www.javatpoint.com/downcasting-with-instanceof-operator)
  - `if-else` statements are rather cumbersome; think about using switch-case statements instead
  - You can access a nice string representation of each choice using `GameChoices`, e.g., `GameChoices.SPOCK`. Do not change `GameChoices`!


### Bonus Challenges (*optional*)
* Add a leaderboard:
  * Store the players' names and the number of games they have won
  * Provide a way to search for a specific player
* Feel free to add your own (more complex) customization to the project!

**Happy coding!**

### Mini Intro to Polymorphism (L18/19)
While you cannot instantiate an abstract class, you can use it as a 'generic' class type to instantiate it later with the specific subclass type! 

**Example:** `Animal` is an abstract class and subclassed by (non-abstract) `Cat` and `Dog` classes.
Hence:
```
Animal animal;
if (someCondition) {
  animal = new Cat();
} else {
  animal = new Dog();
}
```
