package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * GameGUI handles the Graphical User Interface using Java Swing.
 * It is completely separated from the Board logic, maintaining SOLID principles.
 */
public class GameGUI extends JFrame {
    private final Board board;

    /**
     * Constructor to initialize the window settings and connect to the game board.
     */
    public GameGUI(Board board) {
        this.board = board;

        // Set up the basic window properties
        setTitle("Connect Four - Master's Edition");
        setSize(800, 700); // Width and Height of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when window is closed
        setLocationRelativeTo(null); // Center the window on the screen

        // Use BorderLayout to easily arrange buttons at the top and grid in the center
        setLayout(new BorderLayout());
    }

    /**
     * Helper method to make the window visible.
     */
    public void display() {
        setVisible(true);
    }
}