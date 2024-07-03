public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int a = read(), d = read();
        int sr = read(), sc = read();
        boolean meet = sr == n && ((d == 0 && n % 2 == 1) || (d == 1 && n % 2 == 0));
        System.out.println(meet ? "YES!" : "NO...");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
