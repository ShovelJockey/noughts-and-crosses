package NandC;

import java.util.ArrayList;
import java.util.List;

public class computerPlayer {
    private final Board board;
    final private String humanPlayerSymbol;
    final private String computerPlayerSymbol;
    private userInterface ui;

    public computerPlayer(Board board, String humanPlayerSymbol, String computerPlayerSymbol, userInterface ui) {
        this.board = board;
        this.humanPlayerSymbol = humanPlayerSymbol;
        this.computerPlayerSymbol = computerPlayerSymbol;
        this.ui = ui;
    }

    public testPlayInfo minimax(List<String> currentBoardState, String currentSymbol) {
        final List<Integer> currentFreeCells = this.board.getFreeCells(currentBoardState);

        if (this.board.defWins(currentBoardState, computerPlayerSymbol)) {
            testPlayInfo res = new testPlayInfo();
            res.score = 1;
            return res;
        } else if (this.board.defWins(currentBoardState, humanPlayerSymbol)) {
            testPlayInfo res = new testPlayInfo();
            res.score = -1;
            return res;
        } else if (currentFreeCells.isEmpty()) {
            testPlayInfo res = new testPlayInfo();
            res.score = 0;
            return res;
        }

        final List<testPlayInfo> allTestPlayOutcomes = new ArrayList<>();

        for (int i=0; i < currentFreeCells.size(); i++) {

            final testPlayInfo currentTestPlayInfo = new testPlayInfo();

            currentTestPlayInfo.index = currentFreeCells.get(i);
            currentBoardState.set(currentTestPlayInfo.index, currentSymbol);

            if (currentSymbol.equals(computerPlayerSymbol)) {
                final testPlayInfo result = minimax(currentBoardState, humanPlayerSymbol);
                currentTestPlayInfo.score = result.score;
            } else {
                final testPlayInfo result = minimax(currentBoardState, computerPlayerSymbol);
                currentTestPlayInfo.score = result.score;
            }

            currentBoardState.set(currentTestPlayInfo.index, "-");

            allTestPlayOutcomes.add(currentTestPlayInfo);

        }

        int bestTestMove = 0;


        if (currentSymbol.equals(computerPlayerSymbol)) {
            int bestScore = -1000000;
            for (int i=0; i < allTestPlayOutcomes.size(); i++) {
                if (allTestPlayOutcomes.get(i).score > bestScore) {
                    bestScore = allTestPlayOutcomes.get(i).score;
                    bestTestMove = i;
                }
            }
        } else {
            int bestScore = 1000000;
            for (int i=0; i < allTestPlayOutcomes.size(); i++) {
                if (allTestPlayOutcomes.get(i).score < bestScore) {
                    bestScore = allTestPlayOutcomes.get(i).score;
                    bestTestMove = i;
                }
            }
        }
        for (int i=0; i < allTestPlayOutcomes.size(); i++) {

        }
        return allTestPlayOutcomes.get(bestTestMove);
    }

    public int makeMove(List<String> board) {
        final testPlayInfo moveIndex = minimax(board, computerPlayerSymbol);
        return moveIndex.index;
    }
}


