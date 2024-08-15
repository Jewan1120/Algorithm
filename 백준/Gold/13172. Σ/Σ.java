public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        int t = read();
        int answer = 0;
        while (t-- > 0) {
            int n = read(), s = read();
            int gcd = gcd(n, s);
            n /= gcd;
            s /= gcd;
            answer += s * search(n, MOD - 2) % MOD;
            answer %= MOD;
        }
        System.out.println(answer);
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long search(long b, long n) {
        if (n == 1)
            return b;
        long p = search(b, n / 2);
        long ret = p * p % MOD;
        if (n % 2 == 1) {
            ret = ret * b % MOD;
        }
        return ret;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}