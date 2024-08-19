public class Main {

    public static void main(String[] args) throws Exception {
        int T = read(), W = read();

        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++)
            arr[i] = read();
        int[][] dp = new int[T + 1][W + 1];
        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int gotcha = arr[t] == (w % 2 == 0 ? 1 : 2) ? 1 : 0;
                if (w == 0) {
                    dp[t][w] = dp[t - 1][w] + gotcha;
                } else {
                    dp[t][w] = dp[t - 1][w] + gotcha;
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + gotcha);
                }
            }
        }
        int max = 0;
        for (int w = 0; w <= W; w++)
            max = Math.max(max, dp[T][w]);
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}