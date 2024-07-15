import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (read() == 1)
                    board[i][j] = true;
        int cnt = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 1, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0];
            int x = cur[1];
            int mode = cur[2];
            if (y == n - 1 && x == n - 1) {
                cnt++;
                continue;
            }
            if (mode != 2 && (isValid(y, x + 1)))
                dq.offer(new int[] {y, x + 1, 0});
            if (mode != 0 && (isValid(y + 1, x)))
                dq.offer(new int[] {y + 1, x, 2});
            if (isValid(y, x + 1) && isValid(y + 1, x) && isValid(y + 1, x + 1))
                dq.offer(new int[] {y + 1, x + 1, 1});
        }
        System.out.println(cnt);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n && !board[y][x];
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