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
    }
}
