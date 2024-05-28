public class Main {
    public static void main(String[] args) throws Exception {
        int x = read(), y = read(), w = read(), h = read();
        System.out.println(Math.min(x, Math.min(y, Math.min(w - x, h - y))));
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}