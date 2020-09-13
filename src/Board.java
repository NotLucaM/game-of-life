import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    Cell[][] board;
    int length;
    int height;

    Board(int length, int height) {
        this.length = length;
        this.height = height;

        board = new Cell[length + 2][height + 2];
    }

    public void define(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        for (int i = 0; i < board[0].length; i++) {
            board[0][i] = new Cell('0');
            board[board[0].length - 1][i] = new Cell('0');
        }

        for (int i = 0; i < board.length; i++) {
            board[i][0] = new Cell('0');
            board[i][board[0].length - 1] = new Cell('0');
        }

        in.readLine();
        for (int i = 1; i <= height; i++) {
            String row = in.readLine();
            for (int j = 1; j <= length; j++) {
                board[i][j] = new Cell(row.charAt(j - 1));
            }
        }

    }

    public void print() {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print(board[i][j].state + " ");
            }
            System.out.println("");
        }
    }

    public BoardFrame graphicPrint() {
        return new BoardFrame(this);
    }

    public void nextBoard() {
        Cell[][] newBoard = new Cell[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            newBoard[0][i] = new Cell('0');
            newBoard[board[0].length - 1][i] = new Cell('0');
        }

        for (int i = 0; i < board.length; i++) {
            newBoard[i][0] = new Cell('0');
            newBoard[i][board[0].length - 1] = new Cell('0');
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= height; j++) {
                newBoard[i][j] = board[i][j].getState(board[i - 1][j - 1], board[i - 1][j], board[i- 1][j + 1],
                                                            board[i + 1][j - 1], board[i + 1][j], board[i + 1][j + 1],
                                                            board[i][j - 1], board[i][j + 1]);
            }
        }

        board = newBoard;
    }
}