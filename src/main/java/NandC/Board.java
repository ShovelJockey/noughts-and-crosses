package NandC;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<String> cells;

    public Board() {
        this.cells = new ArrayList<>();
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
        this.cells.add("-");
    }

    public String getCell(int index) {
        return this.cells.get(index);
    }

    public List<Integer> getFreeCells(List<String> board) {
        List<Integer> freeCells = new ArrayList<>();
        for (int i=0; i < board.size(); i++) {
            String var = board.get(i);
            if (!var.equals("X") && !var.equals("O")) {
                freeCells.add(i);
            }
        }
        return freeCells;
    }

    public boolean safeSetCell(int index, String symbol) {
        if (!this.cells.get(index).equals("X") && !this.cells.get(index).equals("O")) {
            this.cells.set(index, symbol);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean defWins(List<String> board, String symbol) {
        return (board.get(0).equals(symbol) && board.get(1).equals(symbol) && board.get(2).equals(symbol)) || //top row left-right
                (board.get(3).equals(symbol) && board.get(4).equals(symbol) && board.get(5).equals(symbol)) || //middle row left-right
                (board.get(6).equals(symbol) && board.get(7).equals(symbol) && board.get(8).equals(symbol)) || //bottom row left-right
                (board.get(0).equals(symbol) && board.get(3).equals(symbol) && board.get(6).equals(symbol)) || //left column top-bot
                (board.get(1).equals(symbol) && board.get(4).equals(symbol) && board.get(7).equals(symbol)) || //middle column top-bot
                (board.get(2).equals(symbol) && board.get(5).equals(symbol) && board.get(8).equals(symbol)) || //right column top-bot
                (board.get(2).equals(symbol) && board.get(4).equals(symbol) && board.get(6).equals(symbol)) || //diagonal top right to bottom left
                (board.get(0).equals(symbol) && board.get(4).equals(symbol) && board.get(8).equals(symbol));   //diagonal top left to bottom right
    }
}
