public class Main {

    static int n, k;
    static int max = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        recursive(0, 0, 0);
        System.out.println(max);
    }

    private static void recursive(int depth, int sum, int total) {
        if (depth == n) {
            max = Math.max(max, total);
            return;
        }
        recursive(depth + 1, 0, total);
        if (sum + arr[depth] >= k)
            recursive(depth + 1, 0, total + sum + arr[depth] - k);
        else
            recursive(depth + 1, sum + arr[depth], total);
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