public class Main {

    public static void main(String[] args) throws Exception {
        long n = read();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[][] a = {{1, 1}, {1, 0}};
        pow(a, n - 1);
        System.out.println(a[0][0]);
    }

    private static void pow(long[][] a, long n) {
        if (n == 1) {
            return;
        }
        long[][] m = {{1, 1}, {1, 0}};
        pow(a, n / 2);
        multi(a, a);
        if (n % 2 != 0) {
            multi(a, m);
        }
    }

    private static void multi(long[][] a, long[][] m) {
        long x = (a[0][0] * m[0][0] + a[0][1] * m[1][0]) % 1_000_000_007;
        long y = (a[0][0] * m[0][1] + a[0][1] * m[1][1]) % 1_000_000_007;
        long z = (a[1][0] * m[0][0] + a[1][1] * m[1][0]) % 1_000_000_007;
        long w = (a[1][0] * m[0][1] + a[1][1] * m[1][1]) % 1_000_000_007;
        a[0][0] = x;
        a[0][1] = y;
        a[1][0] = z;
        a[1][1] = w;
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if (c == 13) {
            System.in.read();
        }
        return n;
    }
}