public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        StringBuilder sb = new StringBuilder();
        if (n == 1 && m == 1) {
            sb.append("1\n1");
        } else if (n == 1 || m == 1) {
            sb.append("2\n");
            if (n == 1) {
                for (int i = 0; i < m; i++) {
                    sb.append(i % 2 + 1).append("\n");
                }
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(i % 2 + 1).append(" ");
                }
            }
        } else {
            sb.append("4\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append((i % 2) * 2 + (j % 2) + 1).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}