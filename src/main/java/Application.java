import java.io.BufferedReader;
import java.io.PrintStream;

public class Application {

    private final Game game;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;


    public Application(Game game, PrintStream printStream, BufferedReader bufferedReader) {
        this.game = game;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        displayTitle();
        game.start();
    }

    private void displayTitle() {
        System.out.println("TIC TAC TOE \n");
    }
    
}
