package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testNewBoardIsCreated() {
        // Create a new game board
        Board board = new Board();

        // Check that the board is successfully created (not null)
        assertNotNull(board, "Board should not be null");
    }

    @Test
    void testBoardDimensions() {
        Board board = new Board();

        // Check that the board has exactly 6 rows and 7 columns
        assertEquals(6, board.getRows(), "Board should have 6 rows");
        assertEquals(7, board.getColumns(), "Board should have 7 columns");
    }

    @Test
    void testNewBoardIsEmpty() {
        Board board = new Board();

        // Check if the bottom-left cell is empty (null) initially
        assertNull(board.getCell(0, 0), "Initial board cells should be empty");
    }

    @Test
    void testDropPieceFallsToBottom() {
        Board board = new Board();

        // Player PINK drops a piece in column 0
        board.dropPiece(0, Player.PINK);

        // We expect the piece to fall to the exact bottom (row 0)
        assertEquals(Player.PINK, board.getCell(0, 0), "The piece should fall to the bottom row (row 0)");
    }

    @Test
    void testDropMultiplePiecesInSameColumn() {
        Board board = new Board();

        // Drop first piece (Pink) in column 0
        board.dropPiece(0, Player.PINK);
        // Drop second piece (Blue) in the SAME column
        board.dropPiece(0, Player.BLUE);

        // The first piece should be at the bottom (row 0)
        assertEquals(Player.PINK, board.getCell(0, 0), "First piece should be at row 0");
        // The second piece should be right above it (row 1)
        assertEquals(Player.BLUE, board.getCell(1, 0), "Second piece should be at row 1");
    }

    @Test
    void testDropPieceInFullColumnThrowsException() {
        Board board = new Board();

        // Fill column 0 with 6 pieces (the maximum capacity)
        for (int i = 0; i < 6; i++) {
            board.dropPiece(0, Player.PINK);
        }

        // Now try to drop a 7th piece in the same column.
        // We expect a RuntimeException to be thrown.
        assertThrows(RuntimeException.class, () -> {
            board.dropPiece(0, Player.BLUE);
        }, "Dropping a piece in a full column should throw an exception");
    }

    @Test
    void testHorizontalWin() {
        Board board = new Board();

        // Player PINK drops 4 pieces in consecutive columns (0, 1, 2, 3)
        board.dropPiece(0, Player.PINK);
        board.dropPiece(1, Player.PINK);
        board.dropPiece(2, Player.PINK);
        board.dropPiece(3, Player.PINK);

        // We expect the checkWinner method to return true for PINK
        assertTrue(board.checkWinner(Player.PINK), "Pink should win with 4 pieces in a horizontal row");
    }

    @Test
    void testVerticalWin() {
        Board board = new Board();

        // Player BLUE drops 4 pieces in the same column (column 0)
        board.dropPiece(0, Player.BLUE);
        board.dropPiece(0, Player.BLUE);
        board.dropPiece(0, Player.BLUE);
        board.dropPiece(0, Player.BLUE);

        // We expect the checkWinner method to return true for BLUE
        assertTrue(board.checkWinner(Player.BLUE), "Blue should win with 4 pieces in a vertical column");
    }

    @Test
    void testDiagonalWin() {
        Board board = new Board();

        // Setup a diagonal win for PINK (bottom-left to top-right)
        // Column 0: 1 Pink
        board.dropPiece(0, Player.PINK);

        // Column 1: 1 Blue, then 1 Pink
        board.dropPiece(1, Player.BLUE);
        board.dropPiece(1, Player.PINK);

        // Column 2: 2 Blues, then 1 Pink
        board.dropPiece(2, Player.BLUE);
        board.dropPiece(2, Player.BLUE);
        board.dropPiece(2, Player.PINK);

        // Column 3: 3 Blues, then 1 Pink
        board.dropPiece(3, Player.BLUE);
        board.dropPiece(3, Player.BLUE);
        board.dropPiece(3, Player.BLUE);
        board.dropPiece(3, Player.PINK);

        // We expect checkWinner to return true for PINK
        assertTrue(board.checkWinner(Player.PINK), "Pink should win with a diagonal line (/)");
    }
}