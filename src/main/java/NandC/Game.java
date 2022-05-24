package NandC;

import java.util.List;
import java.util.Map;

public class Game {
    private final userInterface ui;
    private final Board board;
    private String humanPlayerSymbol;
    private String computerPlayerSymbol;

    public Game (userInterface ui, Board board) {
        this.ui = ui;
        this.board = board;
    }

    public void gameStart() {
        ui.gameIntro();
        Map<String, String> playerSymbols = ui.playerPickChar();
        humanPlayerSymbol = playerSymbols.get("human symbol");
        computerPlayerSymbol = playerSymbols.get("computer symbol");
        computerPlayer computerPlayer = new computerPlayer(this.board, humanPlayerSymbol, computerPlayerSymbol, this.ui);
        runGame(computerPlayer);
    }

    public void runGame(computerPlayer computerPlayer) {
        boolean gameRunning = true;
        do {
            humanPlayerMove();
            if (checkWin()) {
                gameRunning = false;
            } else {
                computerPlayerMove(computerPlayer);
                if (checkWin()) {
                    gameRunning = false;
                }
            }
        } while (gameRunning);
    }

    public void humanPlayerMove() {
        boolean validIndex = false;
        int index;
        do {
            index = this.ui.playerPickCell();
            List<Integer> validCells = this.board.getFreeCells(this.board.cells);
            if (validCells.contains(index)) {
                validIndex = true;
            } else {
                System.out.println("This square is already occupied\n");
            }
        } while (!validIndex);
        this.board.safeSetCell(index, humanPlayerSymbol);
        System.out.printf("%s", this.ui.getBoard(this.board.cells));
    }

    public void computerPlayerMove(computerPlayer compPlayer) {
        int compMove = compPlayer.makeMove(this.board.cells);
        this.board.safeSetCell(compMove, computerPlayerSymbol);
        System.out.printf("%s", this.ui.getBoard(this.board.cells));
    }

    public boolean checkWin() {
        if (this.board.defWins(this.board.cells, humanPlayerSymbol)) {
            System.out.println("You win!");
            return true;
        } else if (this.board.defWins(this.board.cells, computerPlayerSymbol)) {
            System.out.println("You lose!");
            return true;
        } else if (this.board.getFreeCells(this.board.cells).isEmpty()) {
            System.out.println("Its a draw!");
            return true;
        } else {
            return false;
        }
    }
}
