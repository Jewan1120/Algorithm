import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), l = read();
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++)
            arr[i] = read();
        arr[n + 1] = l;
        Arrays.sort(arr);
        int left = 1, right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(arr, m, mid)) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(left);
    }

    private static boolean isPossible(int[] arr, int m, int target) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++)
            cnt += (arr[i] - arr[i - 1] - 1) / target;
        return cnt <= m;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}