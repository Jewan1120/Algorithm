public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        arr[0] = read();
        int min = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = read();
            min = gcd(min, arr[i] - arr[i - 1]);
        }
        System.out.println((arr[n - 1] - arr[0]) / min - (n - 1));
    }
    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}