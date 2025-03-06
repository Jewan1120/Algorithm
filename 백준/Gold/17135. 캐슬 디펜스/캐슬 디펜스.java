import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m, d;
    static boolean[][] board;
    static boolean[][] tempBoard;
    static Deque<int[]> tDq = new ArrayDeque<>();
    static int[] dy = { 0, -1, 0 }, dx = { -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        d = read();
        board = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = read() == 1;
        int maxCnt = 0;
        for (int i = 0; i < m - 2; i++)
            for (int j = i + 1; j < m - 1; j++)
                for (int k = j + 1; k < m; k++)
                    maxCnt = Math.max(maxCnt, simulate(i, j, k));
        System.out.println(maxCnt);
    }

    private static int simulate(int a, int b, int c) {
        tempBoard = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            bfs(n - 1 - i, a);
            bfs(n - 1 - i, b);
            bfs(n - 1 - i, c);
            while (!tDq.isEmpty()) {
                int[] t = tDq.poll();
                if (!tempBoard[t[0]][t[1]]) {
                    tempBoard[t[0]][t[1]] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int sy, int sx) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        dq.offer(new int[] { sy, sx });
        int time = 0;
        while (time < d) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1];
                if (board[y][x] && !tempBoard[y][x]) {
                    tDq.offer(cur);
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx) && !visited[ny][nx]) {
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    }
                }
            }
            time++;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
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