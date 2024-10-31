import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<PriorityQueue<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new PriorityQueue<Integer>());
            for (int j = 0; j < m; j++)
                arr.get(i).add(read());
        }
        PriorityQueue<int[]> pqNatural = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pqReversal = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            int p = arr.get(i).poll();
            pqNatural.offer(new int[] { p, i });
            pqReversal.offer(new int[] { p, i });
        }
        int min = pqReversal.peek()[0] - pqNatural.peek()[0];
        while (true) {
            int[] prev = pqNatural.poll();
            if (arr.get(prev[1]).isEmpty())
                break;
            int next = arr.get(prev[1]).poll();
            pqNatural.offer(new int[] { next, prev[1] });
            pqReversal.offer(new int[] { next, prev[1] });
            min = Math.min(min, pqReversal.peek()[0] - pqNatural.peek()[0]);
        }
        System.out.println(min);
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