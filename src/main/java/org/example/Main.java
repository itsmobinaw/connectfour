package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = Player.PINK;
        boolean gameActive = true;
        int turns = 0; // To track if the board gets full (42 turns max)

        System.out.println("Welcome to Connect Four!");

        while (gameActive && turns < 42) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + ", choose a column (0-6): ");

            try {
                // Get input from the user
                String input = scanner.nextLine();
                int column = Integer.parseInt(input);

                // Check if the column is valid
                if (column < 0 || column > 6) {
                    System.out.println("Invalid column! Please choose a number between 0 and 6.");
                    continue;
                }

                // Drop the piece
                board.dropPiece(column, currentPlayer);
                turns++;

                // Check for a winner
                if (board.checkWinner(currentPlayer)) {
                    board.printBoard();
                    System.out.println("🎉 CONGRATULATIONS! Player " + currentPlayer + " WINS! 🎉");
                    gameActive = false;
                } else {
                    // Switch turn to the other player
                    currentPlayer = (currentPlayer == Player.PINK) ? Player.BLUE : Player.PINK;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            } catch (RuntimeException e) {
                // Catches the "Column is full!" exception we made earlier
                System.out.println("Error: " + e.getMessage() + " Try another column.");
            }
        }

        if (turns == 42 && gameActive) {
            board.printBoard();
            System.out.println("It's a draw! The board is full.");
        }

        scanner.close();
    }
}