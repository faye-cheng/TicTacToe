import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        Player player1 = new Player("Player 1", "X");
        Player player2 = new Player("Player 2", "O");

        Map<Integer, String> board = new HashMap<>();
        board.put(1, "1");
        board.put(2, "2");
        board.put(3, "3");
        board.put(4, "4");
        board.put(5, "5");
        board.put(6, "6");
        board.put(7, "7");
        board.put(8, "8");
        board.put(9, "9");

        Game game = new Game(player1, player2, board, printStream);

        Application application = new Application(game, System.out, bufferedReader);
        application.start();
    }
}
