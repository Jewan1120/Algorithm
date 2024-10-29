public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        long[] dp = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i > 6) {
                for (int j = 2; j < 5; j++)
                    dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
            }
        }
        System.out.println(dp[n]);
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