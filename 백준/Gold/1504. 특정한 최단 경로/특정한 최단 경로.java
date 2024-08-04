import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = read();
        int m = read();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int s = read(), e = read(), w = read();
            graph.get(s).add(new int[] {e, w});
            graph.get(e).add(new int[] {s, w});
        }
        int v = read();
        int u = read();
        int[] dist1 = dijstra(1);
        int[] distv = dijstra(v);
        int[] distu = dijstra(u);
        int min = INF;
        if (!(dist1[v] == INF || distv[u] == INF || distu[n] == INF)) {
            min = Math.min(min, dist1[v] + distv[u] + distu[n]);
        }
        if (!(dist1[u] == INF || distu[v] == INF || distv[n] == INF)) {
            min = Math.min(min, dist1[u] + distu[v] + distv[n]);
        }
        System.out.println(min == INF ? -1 : min);
    }

    private static int[] dijstra(int s) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
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
        return dist;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}