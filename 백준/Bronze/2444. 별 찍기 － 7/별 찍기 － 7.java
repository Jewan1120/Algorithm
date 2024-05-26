public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = n - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if (c == 13)
            System.in.read();
        return n;
    }
}