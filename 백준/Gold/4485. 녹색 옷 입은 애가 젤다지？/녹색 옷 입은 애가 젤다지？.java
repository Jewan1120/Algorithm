import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n;
    static int[][] board;
    static int[][] visited;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (true) {
            n = read();
            if (n == 0)
                break;
            board = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    board[i][j] = read();
                    visited[i][j] = Integer.MAX_VALUE;
                }
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] { 0, 0, board[0][0] });
            visited[0][0] = board[0][0];
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1], p = cur[2];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx) && p + board[ny][nx] < visited[ny][nx]) {
                        int np = p + board[ny][nx];
                        dq.offer(new int[] { ny, nx, np });
                        visited[ny][nx] = np;
                    }
                }
            }
            sb.append("Problem ").append(++t).append(": ").append(visited[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
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
