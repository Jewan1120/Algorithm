public class Main {

    public static void main(String[] args) throws Exception {
        int d = read(), p = read();
        int[] length = new int[p];
        int[] width = new int[p];
        for (int i = 0; i < p; i++) {
            length[i] = read();
            width[i] = read();
        }
        int[] dp = new int[d + 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < p; i++) {
            for (int j = d; j >= length[i]; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - length[i]], width[i]));
            }
        }
        System.out.println(dp[d]);
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