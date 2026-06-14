package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * GameGUI handles the Graphical User Interface using Java Swing.
 * It is completely separated from the Board logic, maintaining SOLID principles.
 */
public class GameGUI extends JFrame {
    private final Board board;

    // UI Components for the Grid
    private JPanel gridPanel;
    private JPanel[][] cellPanels;

    public GameGUI(Board board) {
        this.board = board;

        // Window properties
        setTitle("Connect Four - Master's Edition");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Step 2: Initialize the visual grid
        initializeGrid();
    }

    /**
     * Creates a 6x7 grid layout and fills it with empty white panels (slots).
     */
    private void initializeGrid() {
        int rows = board.getRows();
        int cols = board.getColumns();

        gridPanel = new JPanel();
        // Create a grid layout with 5 pixels of spacing between cells
        gridPanel.setLayout(new GridLayout(rows, cols, 5, 5));
        gridPanel.setBackground(Color.DARK_GRAY); // The color of the board frame

        cellPanels = new JPanel[rows][cols];

        // Fill the grid with empty white slots
        // We loop from top row down to bottom, so it displays correctly on screen
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE); // Empty slot color

                // Keep a reference to update colors later
                cellPanels[r][c] = cell;
                gridPanel.add(cell);
            }
        }

        // Add the finished grid to the center of our window
        add(gridPanel, BorderLayout.CENTER);
    }

    public void display() {
        setVisible(true);
    }
}