package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * GameGUI handles the Graphical User Interface using Java Swing.
 * It is completely separated from the Board logic, maintaining SOLID principles.
 */
public class GameGUI extends JFrame {
    private final Board board;

    // UI Components
    private JPanel gridPanel;
    private JPanel[][] cellPanels;
    private JButton[] columnButtons;

    // Game State specific to the UI
    private Player currentPlayer = Player.PINK;
    private boolean gameActive = true;

    public GameGUI(Board board) {
        this.board = board;

        // Window properties
        setTitle("Connect Four - Master's Edition");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initializeButtons();
        initializeGrid();
    }

    /**
     * Creates a top panel with 7 buttons and adds click listeners to them.
     */
    private void initializeButtons() {
        int cols = board.getColumns();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, cols, 5, 5));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        columnButtons = new JButton[cols];

        for (int c = 0; c < cols; c++) {
            JButton button = new JButton("Drop " + c);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setFocusable(false);

            // Step 4: Add an Action Listener to handle button clicks
            final int colIndex = c;
            button.addActionListener(e -> handleColumnClick(colIndex));

            columnButtons[c] = button;
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.NORTH);
    }

    /**
     * Creates a 6x7 grid layout and fills it with empty white panels (slots).
     */
    private void initializeGrid() {
        int rows = board.getRows();
        int cols = board.getColumns();

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols, 5, 5));
        gridPanel.setBackground(Color.DARK_GRAY);

        cellPanels = new JPanel[rows][cols];

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE);
                cellPanels[r][c] = cell;
                gridPanel.add(cell);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
    }

    /**
     * Handles the logic when a user clicks a column button.
     */
    private void handleColumnClick(int col) {
        if (!gameActive) {
            return; // Ignore clicks if the game is over
        }

        try {
            // Drop the piece in the logical board
            board.dropPiece(col, currentPlayer);

            // Refresh the UI to show the new piece
            updateBoardUI();

            // Check for a win or draw
            if (board.checkWinner(currentPlayer)) {
                JOptionPane.showMessageDialog(this, "🎉 Player " + currentPlayer + " Wins! 🎉");
                gameActive = false;
            } else if (board.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a Draw! The board is full.");
                gameActive = false;
            } else {
                // Switch turns
                currentPlayer = (currentPlayer == Player.PINK) ? Player.BLUE : Player.PINK;
            }
        } catch (RuntimeException ex) {
            // If the column is full, show an error popup
            JOptionPane.showMessageDialog(this, "Column is full! Choose another one.");
        }
    }

    /**
     * Syncs the visual grid colors with the logical Board state.
     */
    private void updateBoardUI() {
        int rows = board.getRows();
        int cols = board.getColumns();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Player piece = board.getCell(r, c);
                if (piece == Player.PINK) {
                    cellPanels[r][c].setBackground(Color.MAGENTA); // Magenta visually represents Pink
                } else if (piece == Player.BLUE) {
                    cellPanels[r][c].setBackground(Color.BLUE);
                }
            }
        }
    }

    public void display() {
        setVisible(true);
    }
}