public class Main {

    public static void main(String[] args) throws Exception {
        int a = read(), b = read();
        int l = 0, r = 0;
        while (a > 1 || b > 1) {
            if (a > b) {
                l++;
                a -= b;
            } else {
                r++;
                b -= a;
            }
        }
        System.out.println(l + " " + r);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}