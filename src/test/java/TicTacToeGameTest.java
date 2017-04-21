import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeGameTest {
    PrintStream printStream;
    String[] gameBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldDrawTicTacToeBoardWhenGameStarts() {
        TicTacToeGame game = new TicTacToeGame();
        game.drawBoard(gameBoard);
        verify(printStream).println(contains("1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |"));
    }
}