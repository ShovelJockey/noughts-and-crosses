package NandC;

public class gameMaker {
    public gameMaker() {
        Board board = new Board();
        userInterface ui = new userInterface();
        Game game = new Game(ui, board);
        game.gameStart();
    }
}
