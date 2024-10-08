import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] W = new int[n + 1];
        int[] E = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            W[i] = read();
        for (int i = 1; i < n + 1; i++)
            E[i] = read();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            long maxW = W[i];
            long maxE = E[i];
            for (int j = i; j > 0; j--) {
                maxW = Math.max(maxW, W[j]);
                maxE = Math.max(maxE, E[j]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxE * maxW);
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