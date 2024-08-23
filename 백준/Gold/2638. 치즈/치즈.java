import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        boolean[][] board = new boolean[n][m];
        int total = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (read() == 1) {
                    board[i][j] = true;
                    total++;
                }
        int time = 0;
        while (total > 0) {
            time++;
            boolean[][] nextBoard = new boolean[n][m];
            for (int i = 0; i < n; i++)
                nextBoard[i] = board[i].clone();
            int[][] chkBoard = new int[n][m];
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] { 0, 0 });
            int cnt = 0;
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                if (chkBoard[cur[0]][cur[1]] == -1)
                    continue;
                chkBoard[cur[0]][cur[1]] = -1;
                for (int i = 0; i < 4; i++) {
                    int y = cur[0] + dy[i];
                    int x = cur[1] + dx[i];
                    if (isValid(y, x)) {
                        if (board[y][x]) {
                            chkBoard[y][x]++;
                            if (chkBoard[y][x] == 2) {
                                cnt++;
                                nextBoard[y][x] = false;
                            }
                        } else {
                            dq.offer(new int[] { y, x });
                        }
                    }
                }
            }
            board = nextBoard;
            total -= cnt;
        }
        System.out.println(time);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}