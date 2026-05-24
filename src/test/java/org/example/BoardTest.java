package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testNewBoardIsCreated() {
        // قصد داریم یک صفحه بازی جدید بسازیم
        Board board = new Board();

        // چک می‌کنیم که صفحه بازی با موفقیت ساخته شده باشه (خالی یا null نباشه)
        assertNotNull(board, "Board should not be null");
    }@Test
    void testBoardDimensions() {
        Board board = new Board();

        // چک می‌کنیم که تعداد ردیف‌ها دقیقاً ۶ و ستون‌ها ۷ باشه
        assertEquals(6, board.getRows(), "Board should have 6 rows");
        assertEquals(7, board.getColumns(), "Board should have 7 columns");
    }@Test
    void testNewBoardIsEmpty() {
        Board board = new Board();

        // Check if the bottom-left cell is empty (null)
        assertNull(board.getCell(0, 0), "Initial board cells should be empty");
    }
    @Test
    void testDropPieceFallsToBottom() {
        Board board = new Board();

        // بازیکن صورتی یک مهره در ستون 0 می‌اندازد
        board.dropPiece(0, Player.PINK);

        // حالا انتظار داریم مهره دقیقاً در کف زمین، یعنی ردیف 0 قرار بگیره
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
}
