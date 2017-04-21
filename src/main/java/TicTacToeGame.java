import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private PrintStream printStream;
    private String[] ticTacToeBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private List<Integer> previousMoves = new ArrayList<>();
    private List<Integer> player1Moves = new ArrayList<>();
    private List<Integer> player2Moves = new ArrayList<>();
    private int numMoves = 0;
    private boolean player1Turn = true; //otherwise Player 2 turn
    private static final String player1Marker = "X";
    private static final String player2Marker = "O";
    private boolean gameFinished = false;

    public TicTacToeGame() {
        this.printStream = printStream;
    }

    public void start() {
        displayGameTitle();
        TicTacToeGame.drawBoard(ticTacToeBoard);
        promptPlayerForMove(player1Turn);
    }

    public void displayGameTitle() {
        System.out.println("TIC TAC TOE GAME\n");
    }

    public static void drawBoard(String[] gameBoard) {
        for(int i = 0; i < gameBoard.length; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.println("\n-------------");
            }
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
            }
            System.out.print(gameBoard[i] + " | ");
        }
    }

    private void promptPlayerForMove(boolean player1Turn) {

        while (!gameFinished) {
            if (player1Turn) {
                System.out.println("\n\n" + "Player 1, Please enter a move:");
            } else {
                System.out.println("\n\n" + "Player 2, Please enter a move:");
            }
            Scanner scanner = new Scanner(System.in);
            int playerMove = scanner.nextInt();
            processPlayerMove(player1Turn, playerMove);
        } //should stop game after max number of moves is finished
    }

    private void processPlayerMove(boolean player1Turn, int move) {
        if(!previousMoves.contains(move)) {
            if(player1Turn) {
                ticTacToeBoard[move-1] = player1Marker;
                player1Moves.add(move);
                previousMoves.add(move);
                numMoves++;
            } else {
                ticTacToeBoard[move-1] = player2Marker;
                player2Moves.add(move);
                previousMoves.add(move);
                numMoves++;
            }
            drawBoard(ticTacToeBoard);
            switchPlayerTurn(player1Turn);
        } else {
            System.out.println("Sorry, position is already taken.\n");
            drawBoard(ticTacToeBoard);
            promptPlayerForMove(player1Turn);
        }
        checkIfGameWon();
    }

    private void switchPlayerTurn(boolean player1Turn) {
        if(player1Turn) {
            player1Turn = false;
        } else {
            player1Turn = true;
        }
        checkIfGameWon();
        promptPlayerForMove(player1Turn);
    }


    private void checkIfGameWon() {
        if (numMoves > 4){
            checkByRow();
            checkByColumn();
            checkByDiagonal();
            if(numMoves == 9 && !gameFinished) {
                System.out.println("\nGame is a draw.");
                gameFinished = true;
            }
        }
    }

    private void checkByRow() {
        if (player1Moves.contains(1) && player1Moves.contains(2) && player1Moves.contains(3)
                || player1Moves.contains(4) && player1Moves.contains(5) && player1Moves.contains(6)
                || player1Moves.contains(7) && player1Moves.contains(8) && player1Moves.contains(9)) {
            System.out.println("\n\nPlayer 1 wins!");
            gameFinished = true;
        } else if (player2Moves.contains(1) && player2Moves.contains(2) && player2Moves.contains(3)
                || player2Moves.contains(4) && player2Moves.contains(5) && player2Moves.contains(6)
                || player2Moves.contains(7) && player2Moves.contains(8) && player2Moves.contains(9)) {
            System.out.println("\n\nPlayer 2 wins!");
            gameFinished = true;
        } else {
            //continue game
        }
    }

    private void checkByColumn() {
        if (player1Moves.contains(1) && player1Moves.contains(4) && player1Moves.contains(7)
                || player1Moves.contains(2) && player1Moves.contains(5) && player1Moves.contains(8)
                || player1Moves.contains(3) && player1Moves.contains(6) && player1Moves.contains(9)) {
            System.out.println("\n\nPlayer 1 wins!");
            gameFinished = true;
        } else if (player2Moves.contains(1) && player2Moves.contains(4) && player2Moves.contains(7)
                || player2Moves.contains(2) && player2Moves.contains(5) && player2Moves.contains(8)
                || player2Moves.contains(3) && player2Moves.contains(6) && player2Moves.contains(9)) {
            System.out.println("\n\nPlayer 2 wins!");
            gameFinished = true;
        } else {
            //continue game
        }
    }

    private void checkByDiagonal() {
        if (player1Moves.contains(1) && player1Moves.contains(5) && player1Moves.contains(9)
                || player1Moves.contains(3) && player1Moves.contains(5) && player1Moves.contains(7)) {
            System.out.println("\n\nPlayer 1 wins!");
            gameFinished = true;
        } else if (player2Moves.contains(1) && player2Moves.contains(5) && player2Moves.contains(9)
                || player2Moves.contains(3) && player2Moves.contains(5) && player2Moves.contains(7)) {
            System.out.println("\n\nPlayer 2 wins!");
            gameFinished = true;
        } else {
            //continue game
        }
    }
}
