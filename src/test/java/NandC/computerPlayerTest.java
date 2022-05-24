package NandC;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class computerPlayerTest {
    Board board = new Board();
    userInterface ui = new userInterface();
    computerPlayer complayer = new computerPlayer(board, "O", "X", ui);

    @Test
    void minimax() {
        board.safeSetCell(0, "X");
        board.safeSetCell(2, "O");
        board.safeSetCell(3, "X");
        board.safeSetCell(5, "X");
        board.safeSetCell(6, "O");
        board.safeSetCell(7, "O");
        assertEquals(4, complayer.minimax(board.cells, "X").index);
    }

    @Test
    void minimax2ndCase() {
        board.safeSetCell(0, "X");
        board.safeSetCell(2, "O");
        board.safeSetCell(3, "X");
        board.safeSetCell(5, "X");
        board.safeSetCell(4, "O");
        board.safeSetCell(7, "O");
        assertEquals(6, complayer.minimax(board.cells, "X").index);
    }
}