import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++)
                board[i][j] = line.charAt(j) - '0';
        }
        recursion(0);
        System.out.println(sb);
    }

    public static boolean recursion(int depth) {
        if (depth == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    sb.append(board[i][j]);
                sb.append("\n");
            }
            return true;
        }
        int y = depth / 9, x = depth % 9;
        if (board[y][x] == 0) {
            boolean[] possible = isPossible(y, x);
            for (int i = 1; i < 10; i++)
                if (!possible[i]) {
                    board[y][x] = i;
                    if (recursion(depth + 1))
                        return true;
                    board[y][x] = 0;
                }
        } else {
            return recursion(depth + 1);
        }
        return false;
    }

    public static boolean[] isPossible(int y, int x) {
        boolean[] possible = new boolean[10];
        for (int i = 0; i < 9; i++) {
            possible[board[y][i]] = true;
            possible[board[i][x]] = true;
        }
        int ny = (y / 3) * 3;
        int nx = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possible[board[ny + i][nx + j]] = true;
            }
        }
        return possible;
    }
}