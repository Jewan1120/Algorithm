public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int max = 0;
        int min = 1_000_000;
        while (n-- > 0) {
            int x = read();
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        System.out.println(max * min);
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