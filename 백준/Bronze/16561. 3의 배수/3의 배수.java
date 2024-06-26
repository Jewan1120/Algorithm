public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        System.out.println((n / 3 - 1) * (n / 3 - 2) / 2);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}