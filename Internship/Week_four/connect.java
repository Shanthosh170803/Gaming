import java.util.Scanner;
public class connect {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY_SLOT = '.';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    private static char[][] board = new char[ROWS][COLS];
    private static boolean gameWon = false;
    private static boolean gameDraw = false;
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_ONE;
        while (!gameWon && !gameDraw) {
            System.out.println("Player " + currentPlayer + ", choose a column (0-6): ");
            int column = scanner.nextInt();
            if (column >= 0 && column < COLS) {
                if (placeDisk(currentPlayer, column)) {
                    printBoard();
                    if (checkWin(currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                    } else if (isBoardFull()) {
                        System.out.println("It's a draw!");
                        gameDraw = true;
                    }
                    currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
                } else {
                    System.out.println("Column " + column + " is full. Try a different column.");
                }
            } else {
                System.out.println("Invalid column. Choose a column between 0 and 6.");
            }
        }
        scanner.close();
    }
    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY_SLOT;
            }
        }
    }
    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }
    private static boolean placeDisk(char player, int column) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY_SLOT) {
                board[row][column] = player;
                return true;
            }
        }
        return false;
    }
    private static boolean checkWin(char player) {
        return checkHorizontalWin(player) || checkVerticalWin(player) || checkDiagonalWin(player);
    }
    private static boolean checkHorizontalWin(char player) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row][col + 1] == player &&
                    board[row][col + 2] == player && board[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkVerticalWin(char player) {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] == player && board[row + 1][col] == player &&
                    board[row + 2][col] == player && board[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkDiagonalWin(char player) {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player && board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isBoardFull() {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }
}