import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[][] board, countBoard;
    static boolean[][] favorites;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    static int[] score = { 0, 1, 10, 100, 1000 };

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        favorites = new boolean[n * n + 1][n * n + 1];
        PriorityQueue<int[]> pq;
        int v, u;
        int[] info;
        for (int i = 0; i < n * n; i++) {
            pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0]
                    : o1[1] != o2[1] ? o2[1] - o1[1] : o1[2] != o1[2] ? o1[2] - o2[2] : o1[3] - o2[3]);
            v = read();
            for (int j = 0; j < 4; j++) {
                u = read();
                favorites[v][u] = true;
            }
            for (int y = 0; y < n; y++)
                for (int x = 0; x < n; x++) {
                    if (board[y][x] != 0)
                        continue;
                    info = getInfo(v, y, x);
                    pq.offer(info);
                }
            info = pq.poll();
            board[info[2]][info[3]] = v;
        }
        System.out.println(calculateScore());
    }

    private static int[] getInfo(int v, int sy, int sx) {
        int[] info = { 0, 0, sy, sx };
        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i], nx = sx + dx[i];
            if (isValid(ny, nx)) {
                if (favorites[v][board[ny][nx]])
                    info[0]++;
                if (board[ny][nx] == 0)
                    info[1]++;
            }
        }
        return info;
    }

    private static int calculateScore() {
        int totalScore = 0, cnt;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cnt = getInfo(board[i][j], i, j)[0];
                totalScore += score[cnt];
            }
        return totalScore;
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