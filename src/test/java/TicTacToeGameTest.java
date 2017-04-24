import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeGameTest {
    private TicTacToeGame game;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        game = new TicTacToeGame(printStream, bufferedReader);
    }

    @Test
    public void shouldDrawTicTacToeBoardWhenGameStarts() throws IOException {
        String[] gameBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        when(bufferedReader.readLine()).thenReturn("-1");
        game.drawBoard(gameBoard);
        verify(printStream).println(contains("1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |"));
    }

    @Test
    public void shouldPrintGameBoardWithPlayer1SymbolAfterPlayerEntersMove() {

    }

    @Test
    public void shouldPromptPlayer2ForMoveAfterPlayer1FinishesMove() {

    }

    @Test
    public void shouldPrintGameBoardWithPlayer2SymbolAfterPlayerEntersMove() {

    }

    @Test
    public void shouldPrintLocationTakenErrorMessageIfPlayerEntersInvalidMove() {

    }

    @Test
    public void shouldPromptSamePlayerForMoveAfterLocationTakenErrorMessage() {

    }

    @Test
    public void shouldKeepPromptingPlayersUntilBoardIsFilled() {

    }

}