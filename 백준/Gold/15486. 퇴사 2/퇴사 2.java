public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n + 2][3];
        int[] dp = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new int[] { i, read(), read() };
        }
        for (int i = 1; i < n + 2; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + arr[i][1] < n + 2) {
                dp[i + arr[i][1]] = Math.max(dp[i + arr[i][1]], dp[i] + arr[i][2]);
            }
        }
        System.out.println(dp[n + 1]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}