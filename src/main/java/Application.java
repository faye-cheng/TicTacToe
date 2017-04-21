
public class Application {

    public static void start() {
        TicTacToeGame game = new TicTacToeGame();
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println("TIC TAC TOE GAME");
        game.initialize();
    }
}
