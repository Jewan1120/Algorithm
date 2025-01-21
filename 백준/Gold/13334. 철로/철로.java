import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] line = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = read(), b = read();
            line[i] = new int[] { Math.min(a, b), Math.max(a, b) };
        }
        int d = read();
        Arrays.sort(line, (o1, o2) -> o1[1] - o2[1]);
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(line[i][0]);
            while (!pq.isEmpty() && line[i][1] - pq.peek() > d)
                pq.poll();
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
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