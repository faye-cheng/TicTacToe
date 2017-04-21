import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.times;

public class ApplicationTest {
    TicTacToeGame ticTacToeGame;
    PrintStream printStream;
    Application application;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Before
    public void initialize() {
        ticTacToeGame = mock(TicTacToeGame.class);
        printStream = mock(PrintStream.class);
        inputStream = mock(InputStream.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application();
    }
    @Test
    public void shouldDrawGameBoardWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        try {
            application.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        verify(printStream.println("TIC TAC TOE GAME"));
    }

}