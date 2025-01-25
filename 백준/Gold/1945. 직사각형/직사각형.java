import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        double[][] slopes = new double[n][2];
        for (int i = 0; i < n; i++) {
            int xbl = read(), ybl = read(), xtr = read(), ytr = read();
            slopes[i] = new double[] { (double) ytr / xbl, (double) ybl / xtr };
        }
        Arrays.sort(slopes, (o1, o2) -> Double.compare(o1[1], o2[1]));
        int max = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(slopes[i][0]);
            while (!pq.isEmpty() && pq.peek() < slopes[i][1])
                pq.poll();
            max = Math.max(max, pq.size());
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