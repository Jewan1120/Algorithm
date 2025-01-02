import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        TreeMap<Integer, PriorityQueue<Integer>> pq = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int amount = read(), cost = read();
            pq.putIfAbsent(cost, new PriorityQueue<>((o1, o2) -> o2 - o1));
            pq.get(cost).add(amount);
            tm.put(cost, tm.getOrDefault(cost, 0) + amount);
        }
        for (int cost : tm.keySet())
            if (tm.higherKey(cost) != null)
                tm.put(tm.higherKey(cost), tm.get(tm.higherKey(cost)) + tm.get(cost));
        if (tm.get(tm.lastKey()) < m) {
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int cost : pq.keySet()) {
            PriorityQueue<Integer> meat = pq.get(cost);
            int needs = m;
            if (tm.lowerKey(cost) != null)
                needs -= tm.get(tm.lowerKey(cost));
            int cnt = 0;
            while (!meat.isEmpty()) {
                needs -= meat.poll();
                cnt++;
                if (needs <= 0) {
                    min = Math.min(min, cost * cnt);
                    break;
                }
            }
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