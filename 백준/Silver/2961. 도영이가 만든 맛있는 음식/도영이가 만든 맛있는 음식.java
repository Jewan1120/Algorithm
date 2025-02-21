public class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }
        recursive(0, 1, 0);
        System.out.println(min);
    }

    private static void recursive(int depth, int s, int b) {
        if (depth == n) {
            if (!(s == 1 && b == 0))
                min = Math.min(min, Math.abs(s - b));
            return;
        }
        recursive(depth + 1, s * arr[depth][0], b + arr[depth][1]);
        recursive(depth + 1, s, b);
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