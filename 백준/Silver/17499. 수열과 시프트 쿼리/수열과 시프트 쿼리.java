public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int idx = 0;
        while (m-- > 0) {
            int oper = read();
            int s = read();
            if (oper == 1) {
                int p = read();
                arr[(idx + s - 1) % n] += p;
            } else if (oper == 2) {
                idx = (idx - s + n) % n;
            } else {
                idx = (idx + s + n) % n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[(idx + i) % n]).append(" ");
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
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}