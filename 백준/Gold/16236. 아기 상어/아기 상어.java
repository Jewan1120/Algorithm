import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[][] board;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };
    static int sharkY = 0, sharkX = 0, time = 0;
    static int size = 2, eat = 0;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int p = read();
                if (p == 9) {
                    sharkY = i;
                    sharkX = j;
                    p = 0;
                }
                board[i][j] = p;
            }
        while (bfs(sharkY, sharkX)) {
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
        }
        System.out.println(time);
    }

    private static boolean bfs(int y, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[2] != o2[2] ? o1[2] - o2[2] : o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { y, x, 0 });
        boolean[][] visited = new boolean[n][n];
        visited[y][x] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (isValid(ny, nx) && board[ny][nx] <= size && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dq.offer(new int[] { ny, nx, cur[2] + 1 });
                    if (board[ny][nx] != 0 && board[ny][nx] < size) {
                        pq.offer(new int[] { ny, nx, cur[2] + 1 });
                    }
                }
            }
        }
        if (!pq.isEmpty()) {
            int[] shark = pq.poll();
            sharkY = shark[0];
            sharkX = shark[1];
            time += shark[2];
            board[sharkY][sharkX] = 0;
            return true;
        }
        return false;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}