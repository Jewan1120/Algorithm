public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[65];
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            arr[1] += 1;
        }
        while (t-- > 0) {
            int n = read();
            if (arr[n] == 0)
                for (int i = 2; i <= n; i++) {
                    if (arr[i] != 0)
                        continue;
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k <= j; k++) {
                            dp[i][j] += dp[i - 1][k];
                        }
                        arr[i] += dp[i][j];
                    }
                }
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
