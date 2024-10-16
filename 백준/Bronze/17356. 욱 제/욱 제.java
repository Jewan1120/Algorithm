public class Main {

    public static void main(String[] args) throws Exception {
        int A = read(), B = read();
        double M = (B - A) / 400d;
        System.out.println(1 / (1 + Math.pow(10, M)));
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