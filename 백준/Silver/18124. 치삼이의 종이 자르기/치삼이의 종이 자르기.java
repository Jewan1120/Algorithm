public class Main {

    public static void main(String[] args) throws Exception {
        long n = read();
        long s = 1;
        while (n - s > 0)
            s *= 2;
        System.out.println(s - ((s - n) / 2 + 1));
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}