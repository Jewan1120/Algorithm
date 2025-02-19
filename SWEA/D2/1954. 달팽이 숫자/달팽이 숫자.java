import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int n;
    static int[][] board;
    static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            int y = 0, x = 0, dir = 0;
            board[0][0] = 1;
            for (int num = 2; num <= n * n; num++) {
                int ny = y + dy[dir], nx = x + dx[dir];
                if (!isValid(ny, nx) || board[ny][nx] != 0) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }
                y = ny;
                x = nx;
                board[ny][nx] = num;
            }
            sb.append("#").append(tc).append("\n");
            for (int[] line : board) {
                for (int value : line)
                    sb.append(value).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}