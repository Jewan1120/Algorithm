public class Main {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        int n = read();
        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) { // DP 초기화
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) { // 1 ~ n번째 계단까지
            for (int j = 0; j <= 9; j++) { // 끝자리가 j로 끝나는 수의 개수
                if (j > 0) dp[i][j] += dp[i - 1][j - 1];
                if (j < 9) dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= MOD;
            }
        }
        long sum = 0;
        for (long i : dp[n])
            sum = (sum + i) % MOD;
        System.out.println(sum);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}