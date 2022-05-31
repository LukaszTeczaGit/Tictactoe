package com.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Tests {
    Logic logic = new Logic();


    @Test
    void isClicking() {
        logic.click(1,1);
        assertTrue(logic.currentPlayer == -1);
        assertEquals(logic.currentPlayer * -1 , logic.takenButtons[1][1]);
        assertTrue(1 == logic.deactivatedButtons);

    }

    @Test
    void gameStatusDraw() {
        logic.deactivatedButtons = 9;
        logic.gameStatus();
        assertEquals(3,logic.status);
    }

    @Test
    void gameStatusXwins() {
        logic.takenButtons[0][0] = 1;
        logic.takenButtons[0][1] = 1;
        logic.takenButtons[0][2] = 1;
        logic.gameStatus();
        assertEquals(1,logic.status);
    }

    @Test
    void gameStatusOwins() {
        logic.takenButtons[0][0] = -1;
        logic.takenButtons[0][1] = -1;
        logic.takenButtons[0][2] = -1;
        logic.gameStatus();
        assertEquals(-1,logic.status);
    }
}