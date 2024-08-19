public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = System.in.read() & 15;
            }
            System.in.read();
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                if (dp[i][j] != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
        System.out.println(max * max);
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