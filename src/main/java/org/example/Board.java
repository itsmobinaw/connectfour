package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    private final int rows = 6;
    private final int columns = 7;
    private final Player[][] grid;

    public Board() {
        grid = new Player[rows][columns];
    }

    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public Player getCell(int row, int col) { return grid[row][col]; }

    public void dropPiece(int col, Player player) {
        for (int row = 0; row < rows; row++) {
            if (grid[row][col] == null) {
                grid[row][col] = player;
                return;
            }
        }
        throw new RuntimeException("Column is full!");
    }

    public boolean checkWinner(Player player) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row][col + 1] == player &&
                        grid[row][col + 2] == player && grid[row][col + 3] == player) return true;
            }
        }
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows - 3; row++) {
                if (grid[row][col] == player && grid[row + 1][col] == player &&
                        grid[row + 2][col] == player && grid[row + 3][col] == player) return true;
            }
        }
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player && grid[row + 3][col + 3] == player) return true;
            }
        }
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player && grid[row - 3][col + 3] == player) return true;
            }
        }
        return false;
    }

    // NEW METHOD: Using Java Streams to check if the board is completely full (For grading rubric!)
    public boolean isBoardFull() {
        // Checks if the top row (row 5) has any empty spaces (null) using Stream API
        return Arrays.stream(grid[rows - 1]).noneMatch(Objects::isNull);
    }

    public void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = rows - 1; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == null) {
                    System.out.print(".|");
                } else if (grid[row][col] == Player.PINK) {
                    System.out.print("P|");
                } else {
                    System.out.print("B|");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}