public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) k--;
            if (k == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}