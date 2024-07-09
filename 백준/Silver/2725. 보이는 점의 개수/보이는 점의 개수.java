public class Main {

    public static void main(String[] args) throws Exception {
        int c = read();
        StringBuilder sb = new StringBuilder();
        int maxN = 0;
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = read();
            maxN = Math.max(arr[i], maxN);
        }
        int[] dp = new int[maxN + 1];
        dp[1] = 3;
        for (int i = 2; i <= maxN; i++) {
            int cnt = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1)
                    cnt++;
            }
            dp[i] = dp[i - 1] + cnt * 2;
        }
        for (int i = 0; i < c; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}