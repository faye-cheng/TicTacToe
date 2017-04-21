import org.junit.Test;

import org.junit.Before;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeGameTest {
    PrintStream printStream;
    String[] gameBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);

    }

    @Test
    public void shouldDrawTicTacToeBoardWhenGameStarts() {
        TicTacToeGame game = new TicTacToeGame(printStream);
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