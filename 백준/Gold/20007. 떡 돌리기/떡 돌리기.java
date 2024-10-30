import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), x = read(), y = read();
        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            edges.get(u).add(new Edge(v, w));
            edges.get(v).add(new Edge(u, w));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[y] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
        pq.offer(y);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (Edge edge : edges.get(u)) {
                int v = edge.to;
                int w = edge.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(v);
                }
            }
        }
        Arrays.sort(dist);
        if (dist[n - 1] * 2 > x) {
            System.out.println(-1);
            return;
        }
        int idx = 0;
        int day = 0;
        while (idx < n) {
            day++;
            int hp = x;
            while (idx < n && hp >= dist[idx] * 2) {
                hp -= dist[idx] * 2;
                idx++;
            }
        }
        System.out.println(day);
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