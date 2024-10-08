public class Main {

    static boolean[][] star = { { false, false, true, false, false }, { false, false, true, false, false },
            { true, true, true, true, true }, { false, true, true, true, false }, { false, true, false, true, false } };

    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        int n = read();
        int len = (int) Math.pow(5, n);
        board = new boolean[len][len];
        recursive(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int y, int x, int depth) {
        if (depth == 0) {
            board[y][x] = true;
            return;
        }
        int time = (int) Math.pow(5, depth - 1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (star[i][j]) {
                    recursive(y + i * time, x + j * time, depth - 1);
                }
            }
        }
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