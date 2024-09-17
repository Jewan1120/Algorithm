public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] arr = new int[m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + read()) % m;
            arr[sum]++;
        }
        long result = arr[0];
        for (int i = 0; i < m; i++) {
            result += (long) arr[i] * (arr[i] - 1) / 2;
        }
        System.out.println(result);
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