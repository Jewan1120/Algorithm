import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), w = read(), l = read();
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++)
            trucks[i] = read();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < w; i++)
            dq.offer(0);
        int time = 0, sumWeight = 0, truckIdx = 0;
        while (!dq.isEmpty()) {
            time++;
            sumWeight -= dq.poll();
            if (truckIdx < n) {
                if (l >= sumWeight + trucks[truckIdx]) {
                    dq.offer(trucks[truckIdx]);
                    sumWeight += trucks[truckIdx];
                    truckIdx++;
                } else
                    dq.offer(0);
            }
        }
        System.out.println(time);
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