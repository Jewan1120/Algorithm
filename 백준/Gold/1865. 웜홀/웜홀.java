import java.util.ArrayList;

public class Main {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static ArrayList<Edge> edges;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int tc = read();
        for (; tc > 0; tc--) {
            int n = read();
            int m = read();
            int w = read();
            edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = read();
                int v = read();
                int weight = read();
                edges.add(new Edge(u, v, weight));
                edges.add(new Edge(v, u, weight));
            }
            for (int i = 0; i < w; i++) {
                int u = read();
                int v = read();
                int weight = read();
                edges.add(new Edge(u, v, -weight));
            }
            boolean isCycle = false;
            for (int i = 1; i <= n; i++) {
                if (bellmanFord(n, edges.size(), i)) {
                    isCycle = true;
                    break;
                }
            }
            if (isCycle) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean bellmanFord(int v, int e, int s) {
        dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        boolean update = false;

        for (int i = 1; i <= v - 1; i++) {
            update = false;
            for (int j = 0; j < e; j++) {
                Edge edge = edges.get(j);
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if (dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int j = 0; j < e; j++) {
                Edge edge = edges.get(j);
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if (dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return negative ? ~n + 1 : n;
    }
}