public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), s = read(), m = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        boolean[][] dp = new boolean[n + 1][m + 1]; //[n]번째에 가능한 [m]볼륨
        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            int change = arr[i - 1];
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) { // 이전에 가능했던 볼륨에서 변화값을 가감
                    if (j + change <= m) dp[i][j + change] = true;
                    if (j - change >= 0) dp[i][j - change] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) { // 마지막 연주에서 가능한 볼륨
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}