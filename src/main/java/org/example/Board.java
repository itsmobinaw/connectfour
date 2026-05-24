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
                break; // Stop searching once the piece is placed
            }
        }
    }
}