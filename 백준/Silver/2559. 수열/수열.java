public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        int sum = 0, max = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = m; i < n; i++) {
            sum += arr[i] - arr[i - m];
            max = Math.max(max, sum);
        }
        System.out.println(max);
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