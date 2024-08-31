public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), s = read();
        int minLen = Integer.MAX_VALUE;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int l = 0, r = 0;
        int sum = 0;
        while (l <= n && r <= n) {
            if (sum >= s) {
                minLen = Math.min(minLen, r - l);
                sum -= arr[l++];
            } else {
                sum += arr[r++];
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}