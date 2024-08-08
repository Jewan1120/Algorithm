import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int w;
    static int h;
    static int[][] board;
    static int[][] odd = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] even = { { -1, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        w = read();
        h = read();
        board = new int[h + 2][w + 2];
        for (int i = 1; i <= h; i++)
            for (int j = 1; j <= w; j++)
                board[i][j] = read();
        int len = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0 });
        board[0][0] = -1;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 6; i++) {
                int y = cur[0];
                int x = cur[1];
                if (y % 2 == 0) {
                    y += even[i][0];
                    x += even[i][1];
                } else {
                    y += odd[i][0];
                    x += odd[i][1];
                }
                if (isValid(y, x)) {
                    if (board[y][x] == 1)
                        len++;
                    else {
                        dq.offer(new int[] { y, x });
                        board[y][x] = -1;
                    }
                }
            }
        }
        System.out.println(len);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h + 2 && 0 <= x && x < w + 2 && board[y][x] != -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}