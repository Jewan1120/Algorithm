public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        arr[n] = new int[] { arr[0][0], arr[0][1] };
        double area = 0;
        for (int i = 0; i < n; i++) {
            area += ((double) arr[i][0] * arr[i + 1][1]) - ((double) arr[i][1] * arr[i + 1][0]);
        }
        area = Math.abs(area) / 2;
        System.out.printf("%.1f\n", area);
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