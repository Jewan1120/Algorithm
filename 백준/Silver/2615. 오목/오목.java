public class Main {

    static int[][] board = new int[20][20];
    static boolean[][] visited = new boolean[20][20];
    static int[] dy = { 1, 1, 1, 0 }, dx = { -1, 0, 1, 1 };

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 20; i++)
            for (int j = 1; j < 20; j++)
                board[i][j] = read();
        for (int dir = 0; dir < 4; dir++) {
            visited = new boolean[20][20];
            for (int i = 1; i < 20; i++)
                for (int j = 1; j < 20; j++)
                    if (board[i][j] != 0 && !visited[i][j]) {
                        if (check(i, j, dir)) {
                            System.out.println(board[i][j]);
                            if (dir == 0)
                                System.out.println((i + 4) + " " + (j - 4));
                            else
                                System.out.println(i + " " + j);
                            return;
                        }
                    }
        }
        System.out.println(0);
    }

    private static boolean check(int sy, int sx, int dir) {
        int stone = board[sy][sx], cnt = 1;
        visited[sy][sx] = true;
        int ny = sy + dy[dir], nx = sx + dx[dir];
        while (isValid(ny, nx) && board[ny][nx] == stone) {
            visited[ny][nx] = true;
            cnt++;
            ny += dy[dir];
            nx += dx[dir];
        }
        return cnt == 5;
    }

    private static boolean isValid(int y, int x) {
        return 1 <= y && y < 20 && 1 <= x && x < 20;
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