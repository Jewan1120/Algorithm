public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), t = read();
        long[] arr = new long[n + 1];
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int type = read(), p = read(), q = read();
            if (type == 1) {
                arr[p] += q;
            } else {
                long sum = 0;
                for (int i = p; i <= q; i++)
                    sum += arr[i];
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
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