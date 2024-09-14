public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] memory = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++)
            memory[i] = read();
        int sumCost = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = read();
            sumCost += cost[i];
        }
        int[][] dp = new int[n + 1][sumCost + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sumCost + 1; j++) {
                if (j - cost[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i - 1]] + memory[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < sumCost + 1; i++) {
            if (dp[n][i] >= m) {
                System.out.println(i);
                return;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}