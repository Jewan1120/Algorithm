public class Main {

    static final int MOD = 1_000_000_007;

    static long[][] map = { { 0, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 0 } };

    public static void main(String[] args) throws Exception {
        int d = read();
        System.out.println(recursive(d)[0][0]);
    }

    private static long[][] recursive(int d) {
        if (d == 1)
            return map;
        long[][] pow = recursive(d / 2);
        pow = multiply(pow, pow);
        if (d % 2 == 1)
            pow = multiply(pow, map);
        return pow;
    }

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] pow = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    pow[i][j] = (pow[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return pow;
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