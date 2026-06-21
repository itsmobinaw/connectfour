package org.example;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the game board and handles core game logic.
 * This class now strictly follows the Single Responsibility Principle (SRP).
 */
public class Board {
    private final int rows = 6;
    private final int columns = 7;
    private final Player[][] grid;

    /**
     * Constructor to initialize an empty game board.
     */
    public Board() {
        grid = new Player[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Player getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Drops a player's piece into the specified column.
     * The piece will fall to the lowest available empty slot.
     */
    public void dropPiece(int col, Player player) {
        for (int row = 0; row < rows; row++) {
            if (grid[row][col] == null) {
                grid[row][col] = player;
                return;
            }
        }
        throw new RuntimeException("Column is full!");
    }

    /**
     * Scans the entire board to check if the specified player has 4 pieces in a row.
     */
    public boolean checkWinner(Player player) {
        // 1. Check Horizontal
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
        // 2. Check Vertical
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
        // 3. Check Diagonal (Bottom-Left to Top-Right)
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player &&
                        grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        // 4. Check Diagonal (Top-Left to Bottom-Right)
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player &&
                        grid[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Uses Java Stream API to check if the top row is completely full.
     */
    public boolean isBoardFull() {
        return Arrays.stream(grid[rows - 1]).noneMatch(Objects::isNull);
    }

    /**
     * Resets the board for a new game by clearing all cells.
     */
    public void resetBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = null;
            }
        }
    }
}