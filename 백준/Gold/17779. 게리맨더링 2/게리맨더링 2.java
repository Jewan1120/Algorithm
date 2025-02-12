import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, totalSum = 0, totalMin = Integer.MAX_VALUE;

    static int[][] board;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = read();
                totalSum += board[i][j];
            }
        for (int x = 1; x <= n - 2; x++)
            for (int y = 2; y <= n - 1; y++)
                for (int d1 = 1; d1 <= n - 1; d1++)
                    for (int d2 = 1; d2 <= n - 1; d2++) {
                        if (!isValid(x, y, d1, d2))
                            continue;
                        visited = new boolean[n + 1][n + 1];
                        checkBound(x, y, d1, d2);
                        int v1 = bfs(1, 1, x + d1, y + 1);
                        int v2 = bfs(1, n, x + d2 + 1, y);
                        int v3 = bfs(n, n, x + d1 - 1, y + d2 - d1 - 1);
                        int v4 = bfs(n, 1, x + d1 - 1, y + d2 - d1);
                        int v5 = totalSum - v1 - v2 - v3 - v4;
                        int min = Math.min(Math.min(Math.min(v1, v2), Math.min(v3, v4)), v5);
                        int max = Math.max(Math.max(Math.max(v1, v2), Math.max(v3, v4)), v5);
                        totalMin = Math.min(totalMin, max - min);
                    }
        System.out.println(totalMin);
    }

    private static int bfs(int sr, int sc, int er, int ec) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sr, sc });
        visited[sr][sc] = true;
        int sum = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0], c = cur[1];
            sum += board[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (isValid(nr, nc) && !visited[nr][nc] && (nr != er && nc != ec)) {
                    dq.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
        return sum;
    }

    private static void checkBound(int r, int c, int d1, int d2) {
        for (int i = 0; i <= d1; i++) {
            visited[r + i][c - i] = true;
            visited[r + d2 + i][c + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visited[r + i][c + i] = true;
            visited[r + d1 + i][c - d1 + i] = true;
        }
    }

    private static boolean isValid(int r, int c) {
        return 0 < r && r <= n && 0 < c && c <= n;
    }

    private static boolean isValid(int r, int c, int d1, int d2) {
        return 1 <= r && r < r + d1 + d2 && r + d1 + d2 <= n && 1 <= c - d1 && c - d1 < c && c + d2 <= n;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}