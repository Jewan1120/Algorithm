import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        sb.append(comb(2 * n, n)).append(" ").append((int) Math.pow(n, 2));
        System.out.println(sb);
    }
    private static int comb(int a, int b) {
        BigInteger bi = new BigInteger("1");
        for (int i = a; i > 0; i--) {
            if (i > b) bi = bi.multiply(BigInteger.valueOf(i));
            else bi = bi.divide(BigInteger.valueOf(i));
        }
        return bi.mod(BigInteger.valueOf(1_000_000_007)).intValue();
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}