package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = Player.PINK;
        boolean gameActive = true;

        System.out.println("Welcome to Connect Four!");

        // Using our new Stream-based isBoardFull() method
        while (gameActive && !board.isBoardFull()) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + ", choose a column (0-6): ");

            try {
                String input = scanner.nextLine();
                int column = Integer.parseInt(input);

                if (column < 0 || column > 6) {
                    System.out.println("Invalid column! Please choose a number between 0 and 6.");
                    continue;
                }

                board.dropPiece(column, currentPlayer);

                if (board.checkWinner(currentPlayer)) {
                    board.printBoard();
                    System.out.println("🎉 CONGRATULATIONS! Player " + currentPlayer + " WINS! 🎉");
                    gameActive = false;
                } else {
                    currentPlayer = (currentPlayer == Player.PINK) ? Player.BLUE : Player.PINK;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage() + " Try another column.");
            }
        }

        if (board.isBoardFull() && gameActive) {
            board.printBoard();
            System.out.println("It's a draw! The board is full.");
        }

        scanner.close();
    }
}