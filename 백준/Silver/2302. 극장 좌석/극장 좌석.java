public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = read();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        int prev = 0;
        int cnt = 1;
        for (int i = 0; i < m; i++) {
            cnt *= dp[arr[i] - prev - 1];
            prev = arr[i];
        }
        cnt *= dp[n - prev];
        System.out.println(cnt);
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