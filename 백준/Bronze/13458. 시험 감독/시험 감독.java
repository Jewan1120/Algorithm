public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int b = read(), c = read();
        long sum = n;
        for (int i = 0; i < n; i++) {
            arr[i] -= b;
            if (arr[i] > 0) {
                sum += Math.ceil((double) arr[i] / c);
            }
        }
        System.out.println(sum);
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