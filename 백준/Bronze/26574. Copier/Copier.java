public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        int v;
        for (int i = 0; i < n; i++) {
            v = read();
            sb.append(v).append(" ").append(v).append("\n");
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