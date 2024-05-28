public class Main {
    public static void main(String[] args) throws Exception {
        int[] xArr = {10001, -10001};
        int[] yArr = {10001, -10001};
        int n = read();
        for (int i = 0; i < n; i++) {
            int x = read(), y = read();
            xArr[0] = Math.min(xArr[0], x);
            xArr[1] = Math.max(xArr[1], x);
            yArr[0] = Math.min(yArr[0], y);
            yArr[1] = Math.max(yArr[1], y);
        }
        System.out.println((xArr[1] - xArr[0]) * (yArr[1] - yArr[0]));
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}