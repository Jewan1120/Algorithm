import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int score = 0;
        int l = 0, r = n - 1;
        while (m-- > 0 && l <= r) {
            if (arr[r] > 0) {
                score += arr[r];
                r--;
                l++;
            }
        }
        System.out.println(score);
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