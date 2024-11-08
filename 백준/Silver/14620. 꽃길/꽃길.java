public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = { 0, 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 0, 1, -1 };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = read();
        recursive(0, 0, 0);
        System.out.println(min);
    }

    private static void recursive(int depth, int total, int p) {
        if (depth == 3) {
            min = Math.min(min, total);
            return;
        }
        for (int i = p; i < n * n; i++) {
            int y = i / n, x = i % n;
            boolean isPossible = true;
            for (int j = 0; j < 5; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                if (!isValid(ny, nx)) {
                    isPossible = false;
                }
            }
            if (isPossible) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    visited[ny][nx] = true;
                    sum += board[ny][nx];
                }
                recursive(depth + 1, total + sum, i + 1);
                for (int j = 0; j < 5; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    visited[ny][nx] = false;
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n && !visited[y][x];
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