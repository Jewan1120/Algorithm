public class Main {
    public static void main(String[] args) throws Exception {
        int a = read(), b = read();
        if (a - b == 0)
            System.out.println(0);
        else if (a > b)
            System.out.println(1);
        else
            System.out.println(-1);
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