public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(4 * read());
    }
    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}