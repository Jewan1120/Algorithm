public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int t = Math.max(n, m);
        int[] a = new int[t], b = new int[t];
        for (int i = 0; i < n; i++)
            a[i] = read();
        for (int i = 0; i < m; i++)
            b[i] = read();
        int max = 0;
        for (int i = 0; i < t; i++) {
            max = Math.max(max, b[i] - a[i]);
        }
        System.out.println(max);
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