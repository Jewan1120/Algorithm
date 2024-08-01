public class Main {

    static int[] arr = new int[3];
    static int n;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = read();
        recursive(0, 0, n);
        for (int i : arr)
            System.out.println(i);
    }

    private static void recursive(int y, int x, int n) {
        int p = board[y][x];
        boolean flg = false;
        chk: for (int i = y; i < y + n; i++)
            for (int j = x; j < x + n; j++)
                if (board[i][j] != p) {
                    flg = true;
                    break chk;
                }
        if (flg) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int m = n / 3;
                    recursive(y + i * m, x + j * m, m);
                }
            }
        } else {
            arr[p + 1]++;
        }
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