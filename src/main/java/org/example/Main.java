package org.example;

public class Main {
    public static void main(String[] args) {
        // Initialize the core game logic
        Board board = new Board();

        // Connect the game logic to the Graphical User Interface (GUI)
        GameGUI gui = new GameGUI(board);

        // Display the application window
        gui.display();
    }
}