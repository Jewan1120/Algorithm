public class Main {
    public static void main(String[] args) throws Exception {
	    int a1 = read(), a0 = read(), c = read(), n0 = read();
        System.out.println((a1 >= c) && ((a1 - c) * n0 + a0 >= 0) ? 1 : 0);
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