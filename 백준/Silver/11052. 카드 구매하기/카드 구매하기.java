public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    break;
                dp[i] = Math.max(dp[i], dp[i - j - 1] + arr[j]);
            }
        }
        System.out.println(dp[n]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}