import java.io.BufferedReader;
import java.io.PrintStream;

public class Application {

    /*private final TicTacToeGame game;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public Application(TicTacToeGame game, PrintStream printStream, BufferedReader bufferedReader) {
        this.game = game;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }*/

    public Application() {
    }

    public void start() {
        TicTacToeGame game = new TicTacToeGame();
        game.start();
    }
}
