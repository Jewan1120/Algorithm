public class Main {

    public static void main(String[] args) throws Exception {
        int MOD = 1_000_000_000;
        int n = read();
        long[][] dp = new long[n + 1][10];
        for (int i = 1; i < 10; i++)
            dp[1][i] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                if (j != 9)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++)
            sum = (sum + dp[n][i]) % MOD;
        System.out.println(sum);
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