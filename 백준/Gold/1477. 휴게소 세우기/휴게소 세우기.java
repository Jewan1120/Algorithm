import java.util.Arrays;

public class Main {

    static int n, m, l;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        l = read();
        arr = new int[n + 1];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        arr[n] = l;
        Arrays.sort(arr);
        int left = 1, right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(left);
    }

    private static boolean isPossible(int target) {
        int cnt = 0;
        int cur = 0;
        for (int i = 0; i < n + 1; i++) {
            cnt += (arr[i] - cur - 1) / target;
            cur = arr[i];
        }
        return cnt <= m;
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