public class Main {
    public static void main(String[] args) throws Exception {
        long a = read(), b = read();
        System.out.println(a * b / gcd(a, b));
    }
    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}