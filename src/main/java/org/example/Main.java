package org.example;

import java.util.Scanner;

public class Main {
    // ANSI color codes to make the Live Demo visually appealing!
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PINK = "\u001B[35m"; // Magenta used for Pink
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = Player.PINK;
        boolean gameActive = true;

        System.out.println(ANSI_GREEN + "Welcome to Connect Four!" + ANSI_RESET);

        // Game loop runs until someone wins or the board is completely full
        while (gameActive && !board.isBoardFull()) {
            board.printBoard();

            // Determine the text color based on the current player
            String playerColor = (currentPlayer == Player.PINK) ? ANSI_PINK : ANSI_BLUE;
            System.out.println(playerColor + "Player " + currentPlayer + ", choose a column (0-6): " + ANSI_RESET);

            try {
                // Read user input
                String input = scanner.nextLine();
                int column = Integer.parseInt(input);

                // Validate if the column is within the board limits
                if (column < 0 || column > 6) {
                    System.out.println(ANSI_RED + "Invalid column! Please choose a number between 0 and 6." + ANSI_RESET);
                    continue;
                }

                // Attempt to drop the piece in the selected column
                board.dropPiece(column, currentPlayer);

                // Check if this move resulted in a win
                if (board.checkWinner(currentPlayer)) {
                    board.printBoard();
                    System.out.println(playerColor + "🎉 CONGRATULATIONS! Player " + currentPlayer + " WINS! 🎉" + ANSI_RESET);
                    gameActive = false;
                } else {
                    // Switch turn to the other player
                    currentPlayer = (currentPlayer == Player.PINK) ? Player.BLUE : Player.PINK;
                }

            } catch (NumberFormatException e) {
                // Catches non-integer inputs (e.g., typing text instead of numbers)
                System.out.println(ANSI_RED + "Invalid input! Please enter a valid number." + ANSI_RESET);
            } catch (RuntimeException e) {
                // Catches the "Column is full!" exception from the Board class
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + " Try another column." + ANSI_RESET);
            }
        }

        // If the loop ends and no one has won, it's a draw
        if (board.isBoardFull() && gameActive) {
            board.printBoard();
            System.out.println(ANSI_GREEN + "It's a draw! The board is full." + ANSI_RESET);
        }

        scanner.close();
    }
}