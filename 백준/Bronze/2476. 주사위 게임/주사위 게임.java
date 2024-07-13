public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        int max = 0;
        while (t-- > 0) {
            int a = read(), b = read(), c = read();
            int sum = 0;
            if (a == b && b == c) {
                sum = a * 1000 + 10000;
            } else if (a != b && a != c && b != c) {
                sum = Math.max(a, Math.max(b, c)) * 100;
            } else {
                if (a == b) {
                    sum = a * 100 + 1000;
                } else if (b == c) {
                    sum = b * 100 + 1000;
                } else {
                    sum = c * 100 + 1000;
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
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