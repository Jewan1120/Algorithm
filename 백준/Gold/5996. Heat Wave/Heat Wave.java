import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int t = read(), c = read(), s = read(), e = read();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= t; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < c; i++) {
            int v = read(), u = read(), w = read();
            graph.get(v).add(new int[] { u, w });
            graph.get(u).add(new int[] { v, w });
        }
        int[] dist = new int[t + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> dist[o1] - dist[o2]);
        pq.offer(s);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int[] v : graph.get(u)) {
                if (dist[v[0]] > dist[u] + v[1]) {
                    dist[v[0]] = dist[u] + v[1];
                    pq.offer(v[0]);
                }
            }
        }
        System.out.println(dist[e]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}