import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.contains;

public class ApplicationTest {
    TicTacToeGame ticTacToeGame;
    PrintStream printStream;
    BufferedReader bufferedReader;
    Application application;

    @Before
    public void initialize() {
        ticTacToeGame = mock(TicTacToeGame.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(ticTacToeGame, printStream, bufferedReader);
    }

    @Test
    public void shouldPrintTicTacToeGameWhenApplicationStarts() {
        application.start();
        verify(printStream).println("TIC TAC TOE GAME");
    }
    @Test
    public void shouldDrawGameBoardWhenApplicationStarts() throws IOException {
        application.start();
        verify(printStream).println(contains("1 | 2 | 3 | \n" +
                "- - - - -\n" +
                "4 | 5 | 6 | \n" +
                "- - - - -\n" +
                "7 | 8 | 9 | "));
    }

    @Test
    public void shouldPromptPlayer1ForMoveWhenGameStarts() {
        application.start();
        verify(printStream).println(contains("Player 1, Please enter a move:"));
    }

}