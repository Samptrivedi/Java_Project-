# Tic Tac Toe Game

This project is a simple implementation of the classic Tic Tac Toe game using Java with a graphical user interface (GUI) built with Swing. The game allows two players to take turns marking spaces on a 3x3 grid, with the goal of getting three of their marks in a row (horizontally, vertically, or diagonally).

## Project Structure

The project consists of the following files:

- `src/Main.java`: The entry point of the application. Initializes the game and sets up the GUI.
- `src/game/TicTacToe.java`: Contains the game logic, including methods for checking win conditions, handling player turns, and resetting the game.
- `src/game/Board.java`: Represents the game board using a 2D array. Manages the state of the board and provides methods to update it and check for available moves.
- `src/ui/GameWindow.java`: Creates the main GUI window for the game. Sets up the layout, buttons, and displays the game board.
- `src/ui/EventHandlers.java`: Manages user interactions, such as button clicks, updating the game state, and refreshing the GUI based on player actions.

## Features

- Two-player mode: Players can take turns to play the game.
- Win detection: The game checks for win conditions after each move.
- Reset functionality: Players can reset the game to start a new round.

## How to Run the Game

1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone the repository or download the project files.
3. Navigate to the project directory in your terminal.
4. Compile the Java files using the command:
   ```
   javac src/*.java src/game/*.java src/ui/*.java
   ```
5. Run the game using the command:
   ```
   java src/Main
   ```

Enjoy playing Tic Tac Toe!
