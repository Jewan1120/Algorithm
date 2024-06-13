public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), k = read();
        int o = m > k ? k : m;
        int x = n - m > n - k ? n - k : n - m;
        System.out.println(o + x);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}