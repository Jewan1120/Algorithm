public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        int sum = 0;
        while (t-- > 0)
            sum += read();
        System.out.println(sum);

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