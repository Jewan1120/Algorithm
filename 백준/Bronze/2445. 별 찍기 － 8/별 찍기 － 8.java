public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i)).append(" ".repeat((n - i) * 2)).append("*".repeat(i)).append("\n");
        }
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i)).append(" ".repeat((n - i) * 2)).append("*".repeat(i)).append("\n");
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