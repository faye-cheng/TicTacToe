import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    Game game;
    Board board;
    Player player1;
    Player player2;
    PrintStream printStream;
    BufferedReader bufferedReader;
    Application application;

    @Before
    public void initialize() {
        game = mock(Game.class);
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(game, board, player1, player2, printStream, bufferedReader);
    }

    @Test
    public void shouldDrawBoardWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        application.start();

        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptPlayer1ForMoveWhenGameStarts() {
        application.start();
        verify(printStream).println(contains("Player 1, Please enter a move:"));
    }

}