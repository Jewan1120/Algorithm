import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    static int[][] board = new int[501][501];

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++)
            graph.put(i, new HashMap<>());
        for (int i = 0; i < m; i++) {
            int s = read(), e = read(), w = read();
            HashMap<Integer, Integer> edges;
            edges = graph.get(s);
            edges.putIfAbsent(e, w);
            edges.replace(e, Math.min(edges.get(e), w));

            edges = graph.get(e);
            edges.putIfAbsent(s, w);
            edges.replace(s, Math.min(edges.get(s), w));
        }
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
        pq.offer(1);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u])
                continue;
            visited[u] = true;
            HashMap<Integer, Integer> edges = graph.get(u);
            for (int v : edges.keySet()) {
                if (!visited[v] && dist[v] > dist[u] + edges.get(v)) {
                    dist[v] = dist[u] + edges.get(v);
                    pq.offer(v);
                }
            }
        }
        System.out.println(dist[n]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}