public class Main {

    static int n, m;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        int[][] board = new int[n + 1][m + 1];
        boolean[][][] walls = new boolean[n + 1][m + 1][2];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                board[i][j] = read();
        int x1 = read(), y1 = read();
        int x2 = read(), y2 = read();
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);
        int dir = calDir(x1, y1, x2, y2);
        if (!((minX == 0 && maxX == 0) || (minX == n && maxX == n) || (minY == 0 && maxY == 0)
                || (minY == m && maxY == m)))
            if (dir == 0)
                for (int i = 0; i < maxY - minY; i++)
                    walls[minX + 1][minY + i + 1][dir] = true;
            else if (dir == 1)
                for (int i = 0; i < maxX - minX; i++)
                    walls[minX + i + 1][minY + 1][dir] = true;
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[1][1] = true;
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                int increase = Integer.MIN_VALUE;
                if (visited[i - 1][j] && !walls[i][j][0]) {
                    increase = Math.max(increase, board[i - 1][j]);
                }
                if (visited[i][j - 1] && !walls[i][j][1]) {
                    increase = Math.max(increase, board[i][j - 1]);
                }
                if (increase == Integer.MIN_VALUE)
                    continue;
                board[i][j] += increase;
                visited[i][j] = true;
            }
        System.out.println(visited[n][m] ? board[n][m] : "Entity");
    }

    private static int calDir(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 != y2)
            return 0;
        if (y1 == y2 && x1 != x2)
            return 1;
        return -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}