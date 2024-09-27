public class Main {

    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read();
        if (c % 2 == 0)
            System.out.println(a);
        else
            System.out.println(a ^ b);
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