public class Main {
    public static void main(String[] args) throws Exception {
        int a2 = read(), a1 = read(), a0 = read(), c = read(), n0 = read();
        int d = a1 * a1 - 4 * (a2 - c) * a0;
        boolean flg = false;
        if (a2 - c == 0 || d <= 0) {
            flg = (a2 - c) * n0 * n0 + a1 * n0 + a0 >= 0;
        } else {
            double r1 = (-a1 + Math.sqrt(d)) / (2 * (a2 - c));
            double r2 = (-a1 - Math.sqrt(d)) / (2 * (a2 - c));
            flg = r1 <= n0 && r2 <= n0 && (a2 - c) * n0 * n0 + a1 * n0 + a0 >= 0;
        }
        System.out.println(flg ? 1 : 0);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
	    boolean m = n == 13;
	    if(m) n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}