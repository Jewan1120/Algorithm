import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] board = new int[n][n];
        BigInteger[][] dp = new BigInteger[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                board[i][j] = read();
                dp[i][j] = BigInteger.ZERO;
            }
        dp[0][0] = BigInteger.ONE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1)
                    break;
                int jump = board[i][j];
                if (jump == 0)
                    continue;
                if (i + jump < n)
                    dp[i + jump][j] = dp[i + jump][j].add(dp[i][j]);
                if (j + jump < n)
                    dp[i][j + jump] = dp[i][j + jump].add(dp[i][j]);
            }
        System.out.println(dp[n - 1][n - 1]);
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