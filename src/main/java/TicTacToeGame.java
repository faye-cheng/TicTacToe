import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private String[] ticTacToeBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private List<Integer> previousMoves = new ArrayList<>();
    private List<Integer> player1Moves = new ArrayList<>();
    private List<Integer> player2Moves = new ArrayList<>();

    private boolean player1Turn = true; //otherwise Player 2 turn
    private static final String player1Marker = "X";
    private static final String player2Marker = "O";
    private boolean gameWon = false;

    public void initialize() {
        TicTacToeGame.drawBoard(ticTacToeBoard);
        promptPlayerForMove(player1Turn);
    }

    public static void drawBoard(String[] gameBoard) {
        for(int i = 0; i < gameBoard.length; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.println("\n- - - - -");
            }
            System.out.print(gameBoard[i] + " | ");
        }
    }

    private void promptPlayerForMove(boolean player1Turn) {

        while (!gameWon) {
            if (player1Turn) {
                System.out.println("\n\n" + "Player 1, Please enter a move:");
            } else {
                System.out.println("\n\n" + "Player 2, Please enter a move:");
            }
            Scanner scanner = new Scanner(System.in);
            int playerMove = scanner.nextInt();
            processPlayerMove(player1Turn, playerMove);
        } //should stop game after max number of moves is finished
        System.exit(1);
    }

    private void processPlayerMove(boolean player1Turn, int move) {
        if(!previousMoves.contains(move)) {
            if(player1Turn) {
                ticTacToeBoard[move-1] = player1Marker;
                player1Moves.add(move);
            } else {
                ticTacToeBoard[move-1] = player2Marker;
                player2Moves.add(move);
            }
            drawBoard(ticTacToeBoard);
            switchPlayerTurn(player1Turn);
        } else {
            System.out.println("Sorry, move is already taken.");
            promptPlayerForMove(player1Turn);
        }
        determineIfGameWon();
    }

    private void switchPlayerTurn(boolean player1Turn) {
        if(player1Turn) {
            player1Turn = false;
        } else {
            player1Turn = true;
        }
        determineIfGameWon();
        promptPlayerForMove(player1Turn);
    }


    private void determineIfGameWon() {
        determineWinnerByRow();
    }

    private void determineWinnerByRow() {
        if (player1Moves.contains(1) && player1Moves.contains(2) && player1Moves.contains(3)) {
            gameWon = true;
            System.out.println("\n\nPlayer 1 wins!");
        } else if (player2Moves.contains("1") && player2Moves.contains("2") && player2Moves.contains("3")
                || player2Moves.contains("4") && player2Moves.contains("5") && player2Moves.contains("6")
                || player2Moves.contains("7") && player2Moves.contains("8") && player2Moves.contains("9")) {
            System.out.println("\n\nPlayer 2 wins!");
            gameWon = true;
        } else {
            System.out.println("No winner this game.");
        }
    }
}
