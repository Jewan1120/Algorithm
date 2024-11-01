public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i < n + 1; i += 2) {
            dp[i] += dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
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