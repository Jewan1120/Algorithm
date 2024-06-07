public class Main {
    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read();
        System.out.println(a + b - c);
        System.out.println(a * (int) Math.pow(10, (int) Math.log10(b) + 1) + b - c);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}