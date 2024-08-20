import java.util.HashSet;

public class Main {

    static HashSet<Long> hs = new HashSet<>();

    public static void main(String[] args) throws Exception {
        long n = read(), m = read();
        hs.add(1L);
        recursive(n);
        System.out.println(hs.contains(m) ? "YES" : "NO");
    }

    private static void recursive(long n) {
        if (n == 1 || hs.contains(n))
            return;
        hs.add(n);
        if (n % 2 == 0)
            recursive(n / 2);
        else {
            recursive((n - 1) / 2);
            recursive((n - 1) / 2 + 1);
        }
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}