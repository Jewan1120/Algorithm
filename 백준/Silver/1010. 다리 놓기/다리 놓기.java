public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0)
            sb.append(cal(read(), read())).append("\n");
        System.out.println(sb);
    }
    private static long cal(int a, int b) {
        if (a == 0 || a == b)
            return 1;
        a = Math.min(a, b - a);
        long result = 1;
        for (int i = 0; i < a; i++) {
            result *= b - i;
            result /= i + 1;
        }
        return result;
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}