public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int gcd = 0;
        for (int i = 0; i < n; i++)
            arr[i] = read();
        for (int i = 1; i < n; i++) {
            gcd = GCD(gcd, arr[i] - arr[i - 1]);
        }
        System.out.println((arr[n - 1] - arr[0]) / gcd - (n - 1));
    }

    private static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
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