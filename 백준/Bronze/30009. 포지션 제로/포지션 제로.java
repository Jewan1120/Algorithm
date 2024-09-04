public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int x = read(), y = read(), r = read();
        int cnt1 = 0;
        int cnt2 = 0;
        while (n-- > 0) {
            int p = read();
            if (x - r == p || x + r == p)
                cnt2++;
            else if (x - r < p && x + r > p)
                cnt1++;
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}