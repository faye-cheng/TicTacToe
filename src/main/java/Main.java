import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Application application = new Application(game, System.out, bufferedReader);
        Application application = new Application();
        application.start();
    }
}
