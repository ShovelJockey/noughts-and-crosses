package NandC;

import java.util.*;

public class userInterface {
    public void gameIntro() {
        System.out.println("This is my version of noughts and crosses\nThe aim is occupy 3 spaces in a line of a 3x3 board, be it diagonally, horizontally or vertically.\n" +
                "To play enter a number for the space you wish to place your nought or cross in.\nYou can block the computers attempts to get 3 spaces and it can block you.\n" +
                "The spaces are numbered as such:\n");
        System.out.printf("%s", getExampleBoard());
    }

    public Map<String, String> playerPickChar() {
        Scanner scanner = new Scanner(System.in);
        String playerChoice;
        do {
            System.out.println("Enter either 'O' or 'X' for your board symbol\n");
            playerChoice = scanner.nextLine();
            playerChoice = playerChoice.toUpperCase(Locale.ROOT);
        } while (!playerChoice.equals("X") && !playerChoice.equals("O"));
        Map<String, String> playerSymbols = new HashMap();
        playerSymbols.put("human symbol", playerChoice);
        if (playerChoice.equals("X")) {
            playerSymbols.put("computer symbol", "O");
        } else {
            playerSymbols.put("computer symbol", "X");
        }
        return playerSymbols;
    }

    public String getExampleBoard() {
        return
                "┌───┬───┬───┐\n" +
                "│ 1 │ 2 │ 3 │\n" +
                "│───┼───┼───│\n" +
                "│ 4 │ 5 │ 6 │\n" +
                "│───┼───┼───│\n" +
                "│ 7 │ 8 │ 9 │\n" +
                "└───┴───┴───┘\n";
    }

    public String getBoard(List<String> board) {
        return
                "┌───┬───┬───┐\n" +
                "│ " + board.get(0) + " │ " + board.get(1) + " │ " + board.get(2) + " │\n" +
                "│───┼───┼───│\n" +
                "│ " + board.get(3) + " │ " + board.get(4) + " │ " + board.get(5) + " │\n" +
                "│───┼───┼───│\n" +
                "│ " + board.get(6) + " │ " + board.get(7) + " │ " + board.get(8) + " │\n" +
                "└───┴───┴───┘\n";
    }

    public int playerPickCell() {
        System.out.println("Type a position to place your symbol at.\n");
        List<String> cells = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        Scanner scanner = new Scanner(System.in);
        boolean notValid = true;
        String playerChoice;
        do {
            playerChoice = scanner.nextLine();
            if (cells.contains(playerChoice)) {
                notValid = false;
            } else {
                System.out.println("Sorry that is not a valid position\nIt needs to be a number between 1-9 that has not be taken.");
            }
        } while (notValid);
        int position = Integer.parseInt(playerChoice);
        position = position - 1;
        return position;
    }

}
