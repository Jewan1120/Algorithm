public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        long cnt = 2 * n;
        for (int i = 1; n / 2 > 0; i++, n /= 2) {
            cnt += (1 << i) * (n / 2);
        }
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}