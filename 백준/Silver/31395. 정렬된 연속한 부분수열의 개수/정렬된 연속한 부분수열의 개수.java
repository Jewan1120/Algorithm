public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();

        long cnt = 0;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                cnt += (long) len * (len + 1) / 2;
                len = 1;
            }
        }
        cnt += (long) len * (len + 1) / 2;
        System.out.println(cnt);
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