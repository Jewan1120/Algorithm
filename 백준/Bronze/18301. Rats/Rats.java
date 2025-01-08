public class Main {

    public static void main(String[] args) throws Exception {
        int n1 = read(), n2 = read(), n3 = read();
        System.out.println((n1 + 1) * (n2 + 1) / (n3 + 1) - 1);
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