public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int a = 2024, b = 8 + (n - 1) * 7;
        a += b / 12;
        b %= 12;
        if (b == 0) {
            b = 12;
            a--;
        }
        System.out.println(a + " " + b);
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