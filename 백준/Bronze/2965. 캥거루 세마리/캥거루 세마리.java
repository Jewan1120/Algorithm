public class Main {

    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read();
        System.out.println(Math.max(b - a - 1, c - b - 1));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}