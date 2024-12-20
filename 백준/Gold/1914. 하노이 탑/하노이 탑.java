import java.math.BigInteger;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = read();
        sb.append(BigInteger.TWO.pow(n).subtract(BigInteger.ONE)).append("\n");
        if (n <= 20)
            recursive(n, 1, 2, 3);
        System.out.println(sb);
    }

    private static void recursive(int depth, int s, int m, int e) {
        if (depth == 0) {
            return;
        }
        recursive(depth - 1, s, e, m);
        sb.append(s).append(" ").append(e).append("\n");
        recursive(depth - 1, m, s, e);
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