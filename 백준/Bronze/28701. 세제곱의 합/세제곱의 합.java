public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int k = n * (n + 1) / 2;
        int m = (int) Math.pow(k, 2);
        System.out.println(k);
        System.out.println(m);
        System.out.println(m);
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