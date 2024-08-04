import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int[][] board = new int[501][501];

    public static void main(String[] args) throws Exception {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int n = read();
        for (int i = 0; i < n; i++) {
            int x1 = read(), y1 = read(), x2 = read(), y2 = read();
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                    board[y][x] = 1;
                }
            }
        }
        n = read();
        for (int i = 0; i < n; i++) {
            int x1 = read(), y1 = read(), x2 = read(), y2 = read();
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                    board[y][x] = -1;
                }
            }
        }
        int[][] dist = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0});
        dist[0][0] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (isValid(y, x)) {
                    int cost = board[y][x];
                    if (dist[cur[0]][cur[1]] + cost < dist[y][x]) {
                        dist[y][x] = dist[cur[0]][cur[1]] + cost;
                        if (cost == 1) {
                            dq.addLast(new int[] {y, x});
                        } else {
                            dq.addFirst(new int[] {y, x});
                        }
                    }
                }
            }
        }
        System.out.println(dist[500][500] == Integer.MAX_VALUE ? -1 : dist[500][500]);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y <= 500 && 0 <= x && x <= 500 && board[y][x] != -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}