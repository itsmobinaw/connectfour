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
        for (int row = 0; row < rows; row++) {
            if (grid[row][col] == null) {
                grid[row][col] = player;
                return;
            }
        }
        throw new RuntimeException("Column is full!");
    }

    // Check if the specified player has won the game
    public boolean checkWinner(Player player) {
        // 1. Horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row][col + 1] == player &&
                        grid[row][col + 2] == player && grid[row][col + 3] == player) return true;
            }
        }
        // 2. Vertical
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows - 3; row++) {
                if (grid[row][col] == player && grid[row + 1][col] == player &&
                        grid[row + 2][col] == player && grid[row + 3][col] == player) return true;
            }
        }
        // 3. Diagonal (/)
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player && grid[row + 3][col + 3] == player) return true;
            }
        }
        // 4. Diagonal (\)
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player && grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player && grid[row - 3][col + 3] == player) return true;
            }
        }
        return false;
    }

    // Print the board to the console
    public void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        // Loop from top row (5) down to bottom row (0)
        for (int row = rows - 1; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == null) {
                    System.out.print(".|"); // Empty space
                } else if (grid[row][col] == Player.PINK) {
                    System.out.print("P|"); // Pink piece
                } else {
                    System.out.print("B|"); // Blue piece
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}