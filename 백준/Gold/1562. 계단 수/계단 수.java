public class Main {

    public static void main(String[] args) throws Exception {
        int MOD = 1_000_000_000;
        int n = read();
        long[][][] dp = new long[n + 1][10][1024];
        for (int i = 1; i < 10; i++)
            dp[1][i][1 << i] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    int bit = k | (1 << j);
                    if (j != 0)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                    if (j != 9)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++)
            sum = (sum + dp[n][i][1023]) % MOD;
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