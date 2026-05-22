package org.example;

public class Board {
    // تعریف ابعاد استاندارد بازی دوز 4 تایی
    private final int rows = 6;
    private final int columns = 7;

    // متدی برای برگرداندن تعداد ردیف‌ها
    public int getRows() {
        return rows;
    }

    // متدی برای برگرداندن تعداد ستون‌ها
    public int getColumns() {
        return columns;
    }
}
