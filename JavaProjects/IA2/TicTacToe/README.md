# Assignment 2 - TicTacToe

## Learning objectives
You will practice using reference variables, arrays, and performing operations on arrays.

### Problem
*Your friend wants to implement a Tic-Tac-Toe game in Java. They have already started but got stuck and now ask you for your help to finish it.*

### Your task
Your task is to implement the Tic-Tac-Toe game.

You can find and download the code template here.
The game should allow two players to take turns and make moves on a 3x3 game board.
The program checks for a win, loss, or draw after each move.

## The Game
### **Game Requirements**
*There are TODOs in the code. Make sure to follow them.*
* **`GameBoard`** represents the Tic-Tac-Toe game board.
  * Use a **2D array** to represent the cells on the board
  * Each cell can be empty, contain an `X`, or contain an `O`
  * *Hint: An empty cell could be stored as a `-`, does not need to be printed.*
* * **`Player`** represents a player in the game.
  * Store the player's name and symbol (`X` or `O`)
* **Game Logic**: The main game logic should be inside the **`TicTacToe`** class (make use of methods!).
  * Implement `promptPlayerMove()` that asks players to make a move on the game board.
  * Implement the game logic, consider the following:
    * Check if the board is full
    * Check for a win condition
    * Take a player's move and update the board
    * Switch between players **after each move**
* **User Interaction**: 
   * **After each move**, the current board should be printed to the console in a nice, readable format, containing each player's placed symbols
   * Prompt the user to place a move; the input should be used to make a move
   * When the game ends (the board is full), display a message to announce the winner or declare a draw
   * Ask if the players want to play again after each game (yes/no). If a player wants to play again, restart the game automatically
* **Input Validation**: Make sure that all user input is valid and does not cause the game to unexpectedly abort!

### Other considerations

- Please make sure to provide expressive **comments, print statements, and variable names**.
- **Make sure to follow object-oriented principles and Java best practices!**
- Explanation of the game: https://en.wikipedia.org/wiki/Tic-tac-toe
- If you type 'tic tac toe' in Google, you can play it :-)


### Bonus challenges (*optional*)
* Provide a more user-friendly and more sophisticated way of requesting user input to map to the game board (instead of 00, 01, 02, 10, 11, 12, 20, 21, 22)
* Feel free to add your own (more complex) customization to the project!

**Happy coding!**
