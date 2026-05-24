package org.example;

public class Board {
    private final int rows = 6;
    private final int columns = 7;
    // 2D array to represent the game grid
    private final Player[][] grid;

    public Board() {
        // Initialize an empty grid when a new board is created
        grid = new Player[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Return the player at the specific row and column
    public Player getCell(int row, int col) {
        return grid[row][col];
    }

    // Drop a piece into the specified column
    public void dropPiece(int col, Player player) {
        // Start from the bottom (row 0) and move up to find the first empty spot
        for (int row = 0; row < rows; row++) {
            if (grid[row][col] == null) {
                grid[row][col] = player;
                return; // Stop searching and exit the method once the piece is placed
            }
        }

        // If the loop finishes without finding an empty spot, the column is full!
        throw new RuntimeException("Column is full!");
    }

    // Check if the specified player has won the game
    public boolean checkWinner(Player player) {
        // 1. Check for horizontal wins
        // We loop up to columns - 3 to avoid IndexOutOfBounds error
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row][col + 1] == player &&
                        grid[row][col + 2] == player &&
                        grid[row][col + 3] == player) {
                    return true;
                }
            }
        }

        // 2. Check for vertical wins
        // We loop up to rows - 3 to avoid IndexOutOfBounds error
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows - 3; row++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col] == player &&
                        grid[row + 2][col] == player &&
                        grid[row + 3][col] == player) {
                    return true;
                }
            }
        }

        return false;
    }
}