package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testEnumValues() {
        // Retrieve all players
        Player[] players = Player.values();

        // Ensure exactly two players exist
        assertEquals(2, players.length, "There should be exactly two players in the game");

        // Ensure the players are correctly named PINK and BLUE
        assertEquals(Player.PINK, players[0], "First player should be PINK");
        assertEquals(Player.BLUE, players[1], "Second player should be BLUE");
    }
}