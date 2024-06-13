public class Main {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws Exception {
        int a, b, c;
        StringBuilder sb = new StringBuilder();
        while (true) {
            a = read();
            b = read();
            c = read();
            if (a == -1 && b == -1 && c == -1) break;
            sb.append("w(").append(a).append(", ")
                .append(b).append(", ").append(c)
                .append(") = ").append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }
    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if (dp[a][b][c] != 0) return dp[a][b][c];
        if (a < b && b < c)
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if(m) n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}