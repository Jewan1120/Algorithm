public class Main {
    public static void main(String[] args) throws Exception {
        int a1 = read(), a0 = read(), c1 = read(), c2 = read(), n0 = read();
        boolean g1fn = (c1 <= a1) && ((a1 - c1) * n0 + a0 >= 0);
        boolean g2fn = (c2 >= a1) && ((a1 - c2) * n0 + a0 <= 0);
        System.out.println(g1fn && g2fn ? 1 : 0);
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