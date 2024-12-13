public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] dp = new int[n + 1];
        int l = 0, r = 0;
        int sum = 0;
        while (r < n) {
            sum += arr[r];
            dp[r + 1] = dp[r];
            while (sum >= k) {
                dp[r + 1] = Math.max(dp[r + 1], dp[l] + sum - k);
                sum -= arr[l];
                l++;
            }
            r++;
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