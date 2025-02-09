import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int totalLen = 0, lastPos = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                pq.offer(arr[i]);
            } else {
                if (arr[i][0] <= lastPos) {
                    pq.offer(arr[i]);
                } else {
                    totalLen += lastPos - pq.peek()[0];
                    pq.clear();
                    pq.offer(arr[i]);
                }
            }
            lastPos = Math.max(lastPos, arr[i][1]);
        }
        totalLen += lastPos - pq.peek()[0];
        System.out.println(totalLen);
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