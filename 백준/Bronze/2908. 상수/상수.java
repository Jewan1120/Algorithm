public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            x *= 10;
            x += n % 10;
            y *= 10;
            y += m % 10;
            n /= 10;
            m /= 10;
        }
        System.out.println(Math.max(x, y));
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