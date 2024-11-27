import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenidos al juego de la Trica (Tic Tac Toe)!");
        printBoard();

        while (true) {
            System.out.println("Turno del jugador " + currentPlayer);
            System.out.println("Introduce la fila (1-3): ");
            int row = scanner.nextInt() - 1;

            System.out.println("Introduce la columna (1-3): ");
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("¡El jugador " + currentPlayer + " ha ganado!");
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("¡Es un empate!");
                    break;
                }
            
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("  1   2   3");
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < board.length - 1) {
                System.out.println("---|---|---");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; 
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; 
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; 
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
