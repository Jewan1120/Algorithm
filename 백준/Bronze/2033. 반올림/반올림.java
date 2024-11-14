public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int num = 10;
        while (n > num) {
            if (n % num >= num / 2) {
                n += num;
            }
            n = n - (n % num);
            num *= 10;
        }
        System.out.println(n);
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