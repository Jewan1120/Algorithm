import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, maxCnt;
    static int[][] board;
    static boolean[] visited;

    static int[] dy = { 1, 1, -1, -1 }, dx = { -1, 1, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            maxCnt = 0;
            visited = new boolean[101];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n - 2; i++)
                for (int j = 1; j < n - 1; j++) {
                    recursive(i, j, i, j, 0, 0);
                }
            sb.append("#").append(tc).append(" ").append(maxCnt != 0 ? maxCnt : -1).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int sy, int sx, int y, int x, int dir, int cnt) {
        if (dir == 3 && sy == y && sx == x && cnt >= 4) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        if (visited[board[y][x]])
            return;
        visited[board[y][x]] = true;
        int ny = y + dy[dir], nx = x + dx[dir];
        if (isValid(ny, nx)) {
            recursive(sy, sx, ny, nx, dir, cnt + 1);
        }

        if (dir < 3) {
            ny = y + dy[dir + 1];
            nx = x + dx[dir + 1];
            if (isValid(ny, nx)) {
                recursive(sy, sx, ny, nx, dir + 1, cnt + 1);
            }
        }

        visited[board[y][x]] = false;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}