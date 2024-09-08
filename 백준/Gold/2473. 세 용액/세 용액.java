import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        long max = 3_000_000_001L;
        int[] result = new int[3];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                long sum = (long) arr[i] + arr[l] + arr[r];
                long dist = Math.abs(sum);
                if (max > dist) {
                    max = dist;
                    result = new int[] { arr[i], arr[l], arr[r] };
                }
                if (sum > 0)
                    r--;
                else
                    l++;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}