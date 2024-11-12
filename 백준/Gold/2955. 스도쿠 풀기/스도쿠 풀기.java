import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++)
                if (Character.isDigit(line.charAt(j))) {
                    board[i][j] = line.charAt(j) - '0';
                }
        }
        boolean playFlag = true;
        while (playFlag) {
            playFlag = false;
            for (int num = 1; num <= 9; num++) {
                boolean[][] checkBoard = crossHatching(board, num);
                if (!isValid(num, board, checkBoard)) {
                    System.out.println("ERROR");
                    return;
                }
                for (int i = 0; i < 9; i++)
                    if (putNumber(num, board, i, checkBoard))
                        playFlag = true;
            }
        }
        System.out.println(printBoard(board));
    }

    private static boolean[][] crossHatching(int[][] board, int target) {
        boolean[][] checkBoard = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != 0)
                    checkBoard[i][j] = true;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == target) {
                    check(checkBoard, i, j);
                }
        return checkBoard;
    }

    private static boolean putNumber(int target, int[][] board, int boardNum, boolean[][] checkBoard) {
        ArrayList<int[]> arr = new ArrayList<>();
        int sy = (boardNum / 3) * 3, sx = (boardNum % 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ny = sy + i;
                int nx = sx + j;
                if (!checkBoard[ny][nx])
                    arr.add(new int[] { ny, nx });
            }
        }
        if (arr.size() == 1) {
            int y = arr.get(0)[0];
            int x = arr.get(0)[1];
            board[y][x] = target;
            check(checkBoard, y, x);
            return true;
        }
        return false;
    }

    private static void check(boolean[][] checkBoard, int y, int x) {
        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                checkBoard[sy + i][sx + j] = true;
            }
        for (int i = 0; i < 9; i++) {
            checkBoard[y][i] = true;
            checkBoard[i][x] = true;
        }
    }

    private static boolean isValid(int target, int[][] board, boolean[][] checkBoard) {
        for (int i = 0; i < 9; i++) {
            int putCnt = 0;
            int numCnt = 0;
            int sy = (i / 3) * 3;
            int sx = (i % 3) * 3;
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++) {
                    int ny = sy + j, nx = sx + k;
                    if (board[ny][nx] == target)
                        numCnt++;
                    if (!checkBoard[ny][nx])
                        putCnt++;
                }
            if (numCnt > 1 || putCnt == 0 && numCnt == 0)
                return false;
        }
        return true;
    }

    private static String printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (board[i][j] == 0)
                    sb.append(".");
                else
                    sb.append(board[i][j]);
            sb.append("\n");
        }
        return sb.toString();
    }
}