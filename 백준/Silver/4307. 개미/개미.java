public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int len = read(), n = read();
            int max = 0, min = 0;
            for (int i = 0; i < n; i++) {
                int now = read();
                int l = now, r = len - l;
                max = Math.max(max, Math.max(l, r));
                min = Math.max(min, Math.min(l, r));
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
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