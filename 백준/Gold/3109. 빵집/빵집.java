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
        if (y < 0 || y >= r || board[y][x]) 
            return false; 
        board[y][x] = true;
        return dfs(y - 1, x + 1) || dfs(y, x + 1) || dfs(y + 1, x + 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
