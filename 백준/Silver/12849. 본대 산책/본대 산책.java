public class Main {

    static final int MOD = 1_000_000_007;

    static int[][] map = {
            { 0, 1, 1, 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 1, 0, 0, 0, 0 }, 
            { 1, 1, 0, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 1, 0, 0 }, 
            { 0, 0, 1, 1, 0, 1, 1, 0 }, 
            { 0, 0, 0, 1, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 1 }, 
            { 0, 0, 0, 0, 0, 1, 1, 0 } };

    public static void main(String[] args) throws Exception {
        int d = read();
        int[][] dp = new int[d + 1][8];
        dp[0][0] = 1;
        for (int i = 1; i < d + 1; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (map[k][j] == 1)
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
        System.out.println(dp[d][0]);
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