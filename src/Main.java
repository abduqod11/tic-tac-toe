import java.util.Scanner;

public class Main {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    static int xScore = 0;
    static int yScore = 0;
   static   Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boardList();
        boardPlayer();
        System.out.println("hello");
        while (true) {
            playerMove();
            boardPlayer();
            if(checkBoard()){
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if(checkBoardFull()){
                System.out.println("Player " + currentPlayer + " draw");
            }
            whichPlayer();
        }


    }

    public static void showScore() {
        System.out.println("Score: "+"X-"+xScore + " Y-"+yScore);
        System.out.println("Play again? 1.Yes 2.No");
        int yes=scanner.nextInt();
        switch(yes){
            case 1:
                System.out.println("New game: ");
                boardList();
                boardPlayer();
        }
    }

    public static void boardList() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void boardPlayer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkBoard() {

        //rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        //column
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        //diagonal
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public static void whichPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        checkBoard();
    }

    public static boolean checkBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void playerMove() {

        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + "Enter row column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Wrong! Try again!");
            }
        }
    }


}