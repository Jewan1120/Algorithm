public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        long cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            int l = arr[i], r = arr[n - 1 - i];
            int diff = Math.abs(l - r);
            cnt += diff / k;
            diff %= k;
            if (k - diff < diff)
                cnt += k - diff + 1;
            else
                cnt += diff;
        }
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}