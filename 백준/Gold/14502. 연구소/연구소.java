import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    static int n, m;
    static boolean[][] board;
    static ArrayList<int[]> virusArr = new ArrayList<>();
    static int max = 0;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int p = read();
                if (p != 0) {
                    board[i][j] = true;
                    if (p == 2)
                        virusArr.add(new int[] { i, j });
                }
            }
        recursive(0, 0);
        System.out.println(max);
    }

    private static void recursive(int depth, int p) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = p; i < n * m; i++) {
            int y = i / m;
            int x = i % m;
            if (!board[y][x]) {
                board[y][x] = true;
                recursive(depth + 1, i);
                board[y][x] = false;
            }
        }
    }

    private static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int[] virus : virusArr)
            dq.offer(virus);
        boolean[][] newBoard = new boolean[n][m];
        for (int i = 0; i < n; i++)
            newBoard[i] = board[i].clone();
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (isValid(y, x) && !newBoard[y][x]) {
                    dq.offer(new int[] { y, x });
                    newBoard[y][x] = true;
                }
            }
        }
        int safeZone = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!newBoard[i][j])
                    safeZone++;
        max = Math.max(max, safeZone);
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