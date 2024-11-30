import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        if (k >= n) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < n - k; i++)
            sum += diff[i];
        System.out.println(sum);
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