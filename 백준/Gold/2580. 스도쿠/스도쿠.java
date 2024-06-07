public class Main {
    static int[][] board = new int[9][9];
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = read();
            }
        }
        sudoku(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static boolean sudoku(int y) {
        for (int i = y; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    boolean[] chk = possible(i, j);
                    for (int k = 1; k <= 9; k++) {
                        if (!chk[k]) {
                            board[i][j] = k;
                            if (sudoku(i)) return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean[] possible(int y, int x) {
        boolean[] chk = new boolean[10];
        for (int i = 0; i < 9; i++) {
            chk[board[y][i]] = true;
            chk[board[i][x]] = true;
        }
        int dy = y / 3, dx = x / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                chk[board[3 * dy + i][3 * dx + j]] = true;
            }
        }
        return chk;
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}