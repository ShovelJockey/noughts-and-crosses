package NandC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board testBoard = new Board();

    @Test
    void getCell() {
        assertEquals(testBoard.cells.get(0), testBoard.getCell(0));
        testBoard.safeSetCell(0, "X");
        assertEquals(testBoard.cells.get(0), testBoard.getCell(0));
    }

    @Test
    void getFreeCells() {
        assertEquals(9, testBoard.getFreeCells(testBoard.cells).size());
        testBoard.safeSetCell(0, "X");
        assertEquals(8, testBoard.getFreeCells(testBoard.cells).size());
        testBoard.safeSetCell(1, "O");
        testBoard.safeSetCell(2, "X");
        testBoard.safeSetCell(3, "O");
        testBoard.safeSetCell(4, "X");
        testBoard.safeSetCell(5, "O");
        testBoard.safeSetCell(6, "X");
        testBoard.safeSetCell(7, "O");
        testBoard.safeSetCell(8, "X");
        assertTrue(testBoard.getFreeCells(testBoard.cells).isEmpty());
    }

    @Test
    void safeSetCell() {
        assertTrue(testBoard.safeSetCell(0, "X"));
        assertFalse(testBoard.safeSetCell(0, "O"));
    }

    @Test
    void defWins() {
        assertFalse(testBoard.defWins(testBoard.cells, "X"));
        testBoard.safeSetCell(0, "X");
        testBoard.safeSetCell(1, "X");
        testBoard.safeSetCell(2, "X");
        assertTrue(testBoard.defWins(testBoard.cells, "X"));
        assertFalse(testBoard.defWins(testBoard.cells, "O"));
    }
}