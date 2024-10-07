public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int result = recursive(0, n - 1);
        System.out.println(result);
    }

    private static int recursive(int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int m = l + (r - l + 1) / 2;
        int left = recursive(l, m - 1);
        int rightGcd = getGcd(m, r);

        int right = recursive(m, r);
        int leftGcd = getGcd(l, m - 1);
        return Math.max(left + rightGcd, right + leftGcd);
    }

    private static int getGcd(int s, int e) {
        int totalGcd = arr[s];
        for (int i = s + 1; i <= e; i++)
            totalGcd = gcd(totalGcd, arr[i]);
        return totalGcd;
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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