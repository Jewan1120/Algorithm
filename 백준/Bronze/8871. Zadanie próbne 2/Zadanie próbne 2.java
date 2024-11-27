public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        System.out.println((n + 1) * 2 + " " + (n + 1) * 3);
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