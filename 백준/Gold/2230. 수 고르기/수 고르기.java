import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int l = 0, r = 1;
        int min = Integer.MAX_VALUE;
        while (l < n && r < n) {
            int diff = Math.abs(arr[r] - arr[l]);
            if (diff >= m) {
                min = Math.min(min, diff);
                l++;
            } else {
                r++;
            }
        }
        System.out.println(min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}