import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int c = read(), n = read();
        int[][] ads = new int[n][];
        int maxPeople = 0;
        for (int i = 0; i < n; i++) {
            ads[i] = new int[] { read(), read() };
            maxPeople = Math.max(maxPeople, ads[i][1]);
        }
        int[] dp = new int[c + maxPeople];
        Arrays.fill(dp, Integer.MAX_VALUE >> 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = ads[i][1]; j < c + maxPeople; j++)
                dp[j] = Math.min(dp[j], dp[j - ads[i][1]] + ads[i][0]);
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = c; i < c + maxPeople; i++)
            minCost = Math.min(minCost, dp[i]);
        System.out.println(minCost);
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