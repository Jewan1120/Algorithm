import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int n;

    public static void main(String[] args) throws Exception {
        n = read();
        int m = read();
        int x = read(), y = read();
        int[][] EArr = new int[m][2];
        for (int i = 0; i < m; i++) {
            int A = read(), B = read();
            EArr[i] = new int[] { A, B };
        }
        int[][] board = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(board[i], -1);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { x, y });
        board[x][y] = 0;
        int turn = 1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (isValid(nx, ny) && board[nx][ny] == -1) {
                        dq.offer(new int[] { nx, ny });
                        board[nx][ny] = turn;
                    }
                }
            }
            turn++;
        }
        StringBuilder sb = new StringBuilder();
        for (int[] E : EArr)
            sb.append(board[E[0]][E[1]]).append(" ");
        System.out.println(sb);
    }

    private static boolean isValid(int x, int y) {
        return 0 < x && x <= n && 0 < y && y <= n;
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