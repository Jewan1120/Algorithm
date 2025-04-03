import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, k, maxLen, maxHeight;
    static int[][] board;
    static boolean[][] visited;

    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            maxLen = 0;
            maxHeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, board[i][j]);
                }
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (board[i][j] == maxHeight) {
                        visited = new boolean[n][n];
                        maxLen = Math.max(maxLen, recursive(i, j, false));
                    }
            sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int y, int x, boolean used) {
        visited[y][x] = true;
        int len = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (isValid(ny, nx) && !visited[ny][nx]) {
                if (board[ny][nx] < board[y][x])
                    len = Math.max(len, 1 + recursive(ny, nx, used));
                else if (!used && board[ny][nx] - k < board[y][x]) {
                    int temp = board[ny][nx];
                    board[ny][nx] = board[y][x] - 1;
                    len = Math.max(len, 1 + recursive(ny, nx, true));
                    board[ny][nx] = temp;
                }
            }
        }
        visited[y][x] = false;
        return len;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
