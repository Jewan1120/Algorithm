public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append("*".repeat(n)).append("\n");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}