public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int money = read();
            if (money > k)
                continue;
            dp[money] = 1;
            for (int j = money + 1; j < k + 1; j++) {
                if (dp[j - money] == 0)
                    continue;
                if (dp[j] == 0)
                    dp[j] = dp[j - money] + 1;
                else
                    dp[j] = Math.min(dp[j], dp[j - money] + 1);
            }
        }
        System.out.println(dp[k] != 0 ? dp[k] : -1);
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