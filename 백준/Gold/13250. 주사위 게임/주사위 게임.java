public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        double[] dp = new double[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            for (int j = 1; j <= 6; j++)
                if (i >= j)
                    dp[i] += (1 / 6d) * (dp[i - j] + 1);
                else
                    dp[i] += (1 / 6d);
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