import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { arr[0], 1 });
        long totalCnt = 0;
        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && dq.peekLast()[0] < arr[i]) {
                totalCnt += dq.pollLast()[1];
            }
            int sameCnt = 1;
            if (!dq.isEmpty() && dq.peekLast()[0] == arr[i]) {
                int cnt = dq.pollLast()[1];
                totalCnt += cnt;
                sameCnt += cnt;
            }
            if (!dq.isEmpty())
                totalCnt++;
            dq.offerLast(new int[] { arr[i], sameCnt });
        }
        System.out.println(totalCnt);
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