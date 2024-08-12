public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++)
                coins[i] = read();
            int m = read();
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j < m + 1; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}