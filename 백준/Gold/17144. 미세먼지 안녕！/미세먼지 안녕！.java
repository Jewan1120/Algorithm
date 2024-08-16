public class Main {

    static int r, c, t;
    static int[][] board;
    static int[][] moveBoard;
    static int p = 0;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        r = read();
        c = read();
        t = read();
        board = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                board[i][j] = read();
                if (board[i][j] == -1 && p == 0)
                    p = i;
            }
        while (t-- > 0) {
            moveBoard = new int[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    if (board[i][j] > 0) {
                        spread(i, j);
                    }
                }
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    board[i][j] += moveBoard[i][j];
            rotate();
        }
        int cnt = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (board[i][j] > 0)
                    cnt += board[i][j];
        System.out.println(cnt);
    }

    private static void spread(int y, int x) {
        boolean[] move = new boolean[4];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isValid(ny, nx) && board[ny][nx] != -1) {
                move[i] = true;
            }
        }
        int m = board[y][x] / 5;
        for (int i = 0; i < 4; i++)
            if (move[i]) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                moveBoard[ny][nx] += m;
                moveBoard[y][x] -= m;
            }
    }

    private static void rotate() {
        for (int i = p - 1; i > 0; i--)
            board[i][0] = board[i - 1][0];
        for (int i = 0; i < c - 1; i++)
            board[0][i] = board[0][i + 1];
        for (int i = 0; i < p; i++)
            board[i][c - 1] = board[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[p][i] = board[p][i - 1];
        board[p][1] = 0;
        for (int i = p + 2; i < r - 1; i++)
            board[i][0] = board[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            board[r - 1][i] = board[r - 1][i + 1];
        for (int i = r - 1; i > p + 1; i--)
            board[i][c - 1] = board[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[p + 1][i] = board[p + 1][i - 1];
        board[p + 1][1] = 0;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}