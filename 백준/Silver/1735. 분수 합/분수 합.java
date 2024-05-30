public class Main {
    public static void main(String[] args) throws Exception {
        int a = read(), b = read();
        int c = read(), d = read();
        int n = a * d + c * b, m = b * d;
        int gcd = gcd(n, m);
        System.out.println(new StringBuilder().append(n / gcd).append(" ").append(m / gcd));
    }
    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}