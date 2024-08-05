public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] dp = new int[n + 1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = i - 1;
            if (i % 3 == 0) {
                if (dp[i][0] > dp[i / 3][0] + 1) {
                    dp[i][0] = dp[i / 3][0] + 1;
                    dp[i][1] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (dp[i][0] > dp[i / 2][0] + 1) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = i / 2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][0]).append("\n");
        sb.append(n).append(" ");
        int idx = n;
        for (int i = 0; i < dp[n][0]; i++) {
            int prev = dp[idx][1];
            sb.append(prev).append(" ");
            idx = prev;
        }
        System.out.println(sb);
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