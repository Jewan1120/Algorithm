public class Main {

    static final int MOD = 10_007;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        dp = new int[n + 1][n + 1];
        System.out.println(recursive(n, k));
    }

    public static int recursive(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        if (dp[n][k] == 0)
            dp[n][k] = (recursive(n - 1, k - 1) + recursive(n - 1, k)) % MOD;
        return dp[n][k];
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