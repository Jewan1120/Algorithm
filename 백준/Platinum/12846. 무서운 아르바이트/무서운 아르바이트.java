import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i])
                left[i] += left[dq.pollLast()];
            dq.offerLast(i);
        }
        dq.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i])
                right[i] += right[dq.pollLast()];
            dq.offerLast(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (left[i] + right[i] - 1));
        }
        System.out.println(max);
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