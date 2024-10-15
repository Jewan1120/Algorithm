import java.util.Arrays;

public class Main {

    static int n, c;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        c = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int l = 1, r = arr[n - 1];
        while (l <= r) {
            int param = (l + r) / 2;
            if (isPossible(param)) {
                l = param + 1;
            } else {
                r = param - 1;
            }
        }
        System.out.println(r);
    }

    private static boolean isPossible(int param) {
        int cnt = 1;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[prev] >= param) {
                cnt++;
                prev = i;
            }
        }
        return cnt >= c;
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