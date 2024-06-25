public class Main {
    public static void main(String[] args) throws Exception {
        int a2 = read(), a1 = read(), a0 = read(), c1 = read(), c2 = read(), n0 = read();
        boolean f1 = false, f2 = false;
        
        if (a2 == c1) {
            if (a1 * n0 + a0 >= 0 && a1 >= 0) {
                f1 = true;
            }
        } else if (a2 > c1) {
            int fn1 = f(a2, a1, a0, c1, n0);
            int dfn1 = (a2 - c1) * n0 * 2 + a1;
            int d1 = d(a2, a1, a0, c1);
            if (fn1 >= 0 && (dfn1 >= 0 || d1 <= 0)) {
                f1 = true;
            }
        }
        
        if (a2 == c2) {
            if (a1 * n0 + a0 <= 0 && a1 <= 0) {
                f2 = true;
            }
        } else if (a2 < c2) {
            int fn2 = f(a2, a1, a0, c2, n0);
            int dfn2 = (a2 - c2) * n0 * 2 + a1;
            int d2 = d(a2, a1, a0, c2);
            if (fn2 <= 0 && (dfn2 <= 0 || d2 <= 0)) {
                f2 = true;
            }
        }
        System.out.println(f1 && f2 ? 1 : 0);
    }
    private static int f(int a2, int a1, int a0, int c, int n0) {
        return (a2 - c) * n0 * n0 + a1 * n0 + a0;
    }
    private static int d(int a2, int a1, int a0, int c) {
        return a1 * a1 - 4 * (a2 - c) * a0;
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