import java.util.PriorityQueue;

public class Main {

    static int n, m, k;
    static int[][] board;
    static int[][] A;
    static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 }, dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        board = new int[n + 1][n + 1];
        A = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = 5;
                A[i][j] = read();
            }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++)
            pq.offer(new int[] { read(), read(), read() });
        while (k-- > 0) {
            PriorityQueue<int[]> nPq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            int[][] nextBoard = new int[n + 1][n + 1];
            while (!pq.isEmpty()) {
                int[] tree = pq.poll();
                int y = tree[0], x = tree[1], age = tree[2];
                if (board[y][x] < age) {
                    nextBoard[y][x] += age / 2;
                    continue;
                }
                board[y][x] -= age;
                if (++age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int ny = y + dy[i], nx = x + dx[i];
                        if (isValid(ny, nx))
                            nPq.offer(new int[] { ny, nx, 1 });
                    }
                }
                nPq.offer(new int[] { y, x, age });
            }
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    board[i][j] += A[i][j] + nextBoard[i][j];
            pq = nPq;
        }
        System.out.println(pq.size());
    }

    private static boolean isValid(int y, int x) {
        return 0 < y && y <= n && 0 < x && x <= n;
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