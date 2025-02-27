public class Main {

    static int r, c;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        r = read();
        c = read();
        board = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                if (System.in.read() == 'x')
                    board[i][j] = true;
            System.in.read();
        }
        int cnt = 0;
        for (int i = 0; i < r; i++)
            if (dfs(i, 0))
                cnt++;
        System.out.println(cnt);
    }

    private static boolean dfs(int y, int x) {
        if (x == c)
            return true;
        if (!isValid(y, x))
            return false;
        board[y][x] = true;
        if (!dfs(y - 1, x + 1))
            if (!dfs(y, x + 1))
                if (!dfs(y + 1, x + 1))
                    return false;
                else
                    return true;
            else
                return true;
        else
            return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c && !board[y][x];
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
