public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int score = 0;
        int cnt = 0;
        boolean[][] g = new boolean[6][4];
        boolean[][] b = new boolean[6][4];
        while (n-- > 0) {
            int t = read(), x = read(), y = read();
            if (t == 1) {
                dropBlock(g, 0, y, 0, y);
                dropBlock(b, 0, x, 0, x);
            } else if (t == 2) {
                dropBlock(g, 0, y, 0, y + 1);
                dropBlock(b, 0, x, 1, x);
            } else if (t == 3) {
                dropBlock(g, 0, y, 1, y);
                dropBlock(b, 0, x, 0, x + 1);
            }
            for (int i = 5; i >= 2;) {
                if (checkLine(g, i)) {
                    removeRow(g, i);
                    moveRow(g, i);
                    score++;
                } else
                    i--;
            }
            for (int i = 5; i >= 2;) {
                if (checkLine(b, i)) {
                    removeRow(b, i);
                    moveRow(b, i);
                    score++;
                } else
                    i--;
            }
            while (overLine(b))
                moveRow(b, 5);
            while (overLine(g))
                moveRow(g, 5);
        }
        for (int i = 5; i >= 2; i--)
            for (int j = 0; j < 4; j++) {
                if (b[i][j])
                    cnt++;
                if (g[i][j])
                    cnt++;
            }
        System.out.println(score);
        System.out.println(cnt);
    }

    private static void dropBlock(boolean[][] board, int sr, int sc, int er, int ec) {
        while (sr < 5 && er < 5 && !board[sr + 1][sc] && !board[er + 1][ec]) {
            sr++;
            er++;
        }
        board[sr][sc] = true;
        board[er][ec] = true;
    }

    private static boolean checkLine(boolean[][] board, int r) {
        for (int i = 0; i < 4; i++)
            if (!board[r][i])
                return false;
        return true;
    }

    private static boolean overLine(boolean[][] board) {
        for (int i = 0; i < 4; i++)
            if (board[1][i])
                return true;
        return false;
    }

    private static void removeRow(boolean[][] board, int sR) {
        for (int i = 0; i < 4; i++)
            board[sR][i] = false;
    }

    private static void moveRow(boolean[][] board, int sR) {
        for (int i = sR; i >= 1; i--)
            for (int j = 0; j < 4; j++)
                board[i][j] = board[i - 1][j];
        removeRow(board, 0);
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