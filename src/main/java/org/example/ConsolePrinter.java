package org.example;

/**
 * Handles all console UI rendering for the game.
 * Separating this from the Board class fulfills the Single Responsibility Principle.
 */
public class ConsolePrinter {
    // ANSI color codes for the board pieces relocated from Board class
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PINK = "\u001B[35m";
    private static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Prints the current state of the board to the console.
     * Takes a Board instance as a parameter to read its current state.
     */
    public void printBoard(Board board) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");

        for (int row = board.getRows() - 1; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < board.getColumns(); col++) {
                Player cell = board.getCell(row, col);
                if (cell == null) {
                    System.out.print(".|");
                } else if (cell == Player.PINK) {
                    System.out.print(ANSI_PINK + "●" + ANSI_RESET + "|");
                } else {
                    System.out.print(ANSI_BLUE + "●" + ANSI_RESET + "|");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}