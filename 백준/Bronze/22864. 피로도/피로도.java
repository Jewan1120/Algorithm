public class Main {

    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read(), m = read();
        int p = 0, w = 0;
        for (int i = 1; i <= 24; i++) {
            if (p + a <= m) {
                w += b;
                p += a;
            } else {
                p -= c;
                if (p < 0)
                    p = 0;
            }
        }
        System.out.println(w);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}