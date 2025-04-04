public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[][] board = new boolean[n][n];
        long[][][] dp = new long[3][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = (read() == 0);
        dp[0][0][1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (!board[i][j])
                    continue;
                dp[0][i][j] += dp[0][i][j - 1] + dp[2][i][j - 1];
                if (i > 0) {
                    dp[1][i][j] += dp[1][i - 1][j] + dp[2][i - 1][j];
                    if (board[i - 1][j] && board[i][j - 1])
                        dp[2][i][j] += dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
                }
            }
        }
        System.out.println(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
