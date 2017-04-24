import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private Map<Integer, String> board = new HashMap<>();
    private int numMoves = 0;
    private boolean player1Turn = true; //otherwise Player 2 turn
    private boolean gameFinished = false;
    private PrintStream printStream;

    public Game(Player player1, Player player2, Map<Integer, String> board, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.printStream = printStream;
    }

    public void start() {
        drawBoard();
        promptPlayerForMove();
    }

    public void drawBoard() {
        for(int i = 1; i < board.size()+1; i++) {
            if(i % 3 == 1 && i != 1) {
                System.out.println("\n-------------");
            }
            if (i == 1 || i == 4 || i == 7) {
                System.out.print("| ");
            }
            printStream.print(board.get(i) + " | ");
        }
    }

    public void promptPlayerForMove() {

        while (!gameFinished) {
            if (player1Turn) {
                printStream.println("\n\n" + player1.playerName + ", Please enter a move:");
                processPlayerMove();
            } else {
                printStream.println("\n\n" + player2.playerName + ", Please enter a move:");
                processPlayerMove();
            }
        }
    }

    private void processPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int playerMove = scanner.nextInt();

        if(board.values().contains(Integer.toString(playerMove))) {
            if(player1Turn) {
                board.put(playerMove, player1.marker);
            } else {
                board.put(playerMove, player2.marker);
            }
            numMoves++;
            drawBoard();
            checkIfWon();
            switchPlayerTurn();
            promptPlayerForMove();
        } else {
            printStream.println("Sorry, position is already taken.\n");
            drawBoard();
            promptPlayerForMove();
        }
    }

    private void switchPlayerTurn() {
        if(player1Turn) {
            player1Turn = false;
        } else {
            player1Turn = true;
        }
    }


    private void checkIfWon() {
        if (numMoves > 4){
            checkByRow();
            checkByColumn();
            checkByDiagonal();
            if(numMoves == 9 && !gameFinished) {
                System.out.println("\n\nGame is a draw.");
                gameFinished = true;
            }
        }
    }
    private void determineWinner() {
        if(player1Turn) {
            printStream.println("\n\n" + player1.playerName + " wins!");
        } else {
            printStream.println("\n\n" + player2.playerName + " wins!");
        }
        gameFinished = true;
    }

    private void checkByRow() {
        if((board.get(1).equals(board.get(2)) && board.get(1).equals(board.get(3)))
                || (board.get(4).equals(board.get(5)) && board.get(4).equals(board.get(6))
                || (board.get(7).equals(board.get(8)) && board.get(7).equals(board.get(9))))) {
            determineWinner();
        }
    }

    private void checkByColumn() {

        if((board.get(1).equals(board.get(4)) && board.get(1).equals(board.get(7)))
                || (board.get(2).equals(board.get(5)) && board.get(2).equals(board.get(8))
                || (board.get(3).equals(board.get(6)) && board.get(3).equals(board.get(9))))) {
            determineWinner();
        }
    }

    private void checkByDiagonal() {

        if((board.get(1).equals(board.get(5)) && board.get(1).equals(board.get(9)))
                || (board.get(3).equals(board.get(5)) && board.get(3).equals(board.get(7)))) {
            determineWinner();
        }
    }
}
