public class Main {

    static int n;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        n = read();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = read();
        recursion(board, 0);
        System.out.println(max);
    }

    private static void recursion(int[][] board, int depth) {
        if (depth == 5) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    max = Math.max(max, board[i][j]);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = new int[n][n];
            for (int j = 0; j < n; j++)
                nextBoard[j] = board[j].clone();
            move(nextBoard, i);
            recursion(nextBoard, depth + 1);
        }
    }

    private static void move(int[][] board, int dir) {
        boolean[][] merged = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                switch (dir) {
                case 0:
                    moveTile(board, merged, i, j, -1, 0);
                    break;
                case 1:
                    moveTile(board, merged, n - 1 - i, j, 1, 0);
                    break;
                case 2:
                    moveTile(board, merged, j, i, 0, -1);
                    break;
                case 3:
                    moveTile(board, merged, j, n - 1 - i, 0, 1);
                    break;
                }
    }

    private static void moveTile(int[][] board, boolean[][] merged, int y, int x, int dy, int dx) {
        if (board[y][x] == 0)
            return;
        int ny = y + dy, nx = x + dx;
        while (isValid(ny, nx) && board[ny][nx] == 0) {
            board[ny][nx] = board[y][x];
            board[y][x] = 0;
            y = ny;
            x = nx;
            ny = y + dy;
            nx = x + dx;
        }
        if (isValid(ny, nx) && board[ny][nx] == board[y][x] && !merged[ny][nx]) {
            board[ny][nx] *= 2;
            board[y][x] = 0;
            merged[ny][nx] = true;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}