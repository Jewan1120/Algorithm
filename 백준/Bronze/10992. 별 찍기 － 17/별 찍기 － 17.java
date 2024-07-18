public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(n - i)).append("*");
            if (i > 1)
                sb.append(" ".repeat((i - 1) * 2 - 1)).append("*");
            sb.append("\n");
        }
        sb.append("*".repeat(n * 2 - 1));
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}