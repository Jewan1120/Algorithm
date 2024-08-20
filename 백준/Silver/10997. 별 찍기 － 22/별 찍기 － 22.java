public class Main {

    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        int n = read();
        if (n == 1) {
            System.out.print("*");
            return;
        }
        board = new boolean[4 * n - 1][4 * n - 3];
        recursive(n, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (i == 1) {
                sb.append("*\n");
                continue;
            }
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            if (i != board.length - 1)
                sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void recursive(int n, int y, int x) {
        if (n == 0)
            return;
        int w = 4 * n - 3;
        int h = 4 * n - 1;
        for (int i = 0; i < w; i++)
            board[y][x + i] = true;
        for (int i = 0; i < h; i++)
            board[y + i][x] = true;
        for (int i = 0; i < w; i++)
            board[y + h - 1][x + i] = true;
        for (int i = 0; i < h - 2; i++)
            board[y + 2 + i][x + w - 1] = true;
        if (n != 1)
            board[y + 2][x + w - 2] = true;
        recursive(n - 1, y + 2, x + 2);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}