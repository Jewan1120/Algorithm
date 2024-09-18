public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new int[] { read(), read() };
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int value = dp[i][k] + dp[k + 1][j] + (arr[i][0] * arr[k][1] * arr[j][1]);
                    dp[i][j] = Math.min(dp[i][j], value);
                }
            }
        }
        System.out.println(dp[1][n]);
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