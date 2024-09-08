import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int max = 2_000_000_001;
        int[] result = new int[2];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int dist = Math.abs(sum);
            if (max > dist) {
                max = dist;
                result = new int[] { arr[l], arr[r] };
            }
            if (sum > 0)
                r--;
            else
                l++;
        }
        System.out.println(result[0] + " " + result[1]);
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