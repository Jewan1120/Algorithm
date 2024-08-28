public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        System.out.println((int) (Math.round(n / Math.pow(10, k)) * Math.pow(10, k)));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}